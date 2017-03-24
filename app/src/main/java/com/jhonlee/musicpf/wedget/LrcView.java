package com.jhonlee.musicpf.wedget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.pojo.Lyric;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by JhoneLee on 2017/3/16.
 */

public class LrcView extends View {


    private float mTextSize;//歌词字体大小
    private float mDividerHeight;//选中歌词的高度
    private long mAnimationDuration;//动画执行时间
    private List<Lyric> mList;
    private float mAnimOffset;//动画偏移量
    private int mCurrentLine = 0;//当前显示行
    private Paint mNomalPaint;
    private Paint mCurrentPaint;    //当前播放的字体的画笔
    private WeakReference<LrcView> lrcViewRef;
    private  LrcHandler mHandler;

    public LrcView(Context context, List<Lyric> mList) {
       /* super(context);
        init(mList);*/
        this(context,null,mList);
    }

    public LrcView(Context context, AttributeSet attrs, List<Lyric> mList) {
        super(context,attrs);
        init(mList);
    }

    private void init(List<Lyric> mList){

        lrcViewRef = new WeakReference<LrcView>(this);
        mHandler = new LrcHandler(lrcViewRef);

        TypedArray array = getContext().obtainStyledAttributes(R.styleable.LrcView);
        mTextSize = array.getDimension(R.styleable.LrcView_textSize,32f);
        mDividerHeight = array.getDimension(R.styleable.LrcView_dividerHeight,48f);
        mAnimationDuration = array.getInt(R.styleable.LrcView_animationDuration,
                1000);
        mAnimationDuration = mAnimationDuration < 0 ? 1000 : mAnimationDuration;

        array.recycle();

        mNomalPaint = new Paint();
        mNomalPaint.setColor(Color.WHITE);
        mNomalPaint.setTextSize(mTextSize);

        mCurrentPaint = new Paint();
        mCurrentPaint.setColor(Color.GREEN);
        mCurrentPaint.setTextSize(mTextSize);
        this.mList = mList;
        //得到网络歌词
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mList==null) {
            canvas.drawText("当前暂无歌词", getHeight() / 2, getWidth() / 2, mNomalPaint);
            return;
        }
        float centerY = getHeight()/2+mTextSize/2+mAnimOffset;

        String currentStr = mList.get(mCurrentLine).getLyric();

        float currX = (getWidth() - mCurrentPaint.measureText(currentStr)) / 2;

        canvas.drawText(currentStr, currX, centerY, mCurrentPaint);

        // 画当前行上面的
        for (int i = mCurrentLine - 1; i >= 0; i--) {
            String upStr = mList.get(i).getLyric();
            float upX = (getWidth() - mNomalPaint.measureText(upStr)) / 2;
            float upY = centerY - (mTextSize + mDividerHeight)
                    * (mCurrentLine - i);
            canvas.drawText(upStr, upX, upY, mNomalPaint);
        }

        // 画当前行下面的
        for (int i = mCurrentLine + 1; i < mList.size(); i++) {
            String downStr = mList.get(i).getLyric();
            float downX = (getWidth() - mNomalPaint.measureText(downStr)) / 2;
            float downY = centerY + (mTextSize + mDividerHeight)
                    * (i - mCurrentLine);
            canvas.drawText(downStr, downX, downY, mNomalPaint);
        }

    }

    /**
     * 换行动画 Note:属性动画只能在主线程使用
     */
    private void newLineAnim() {
        ValueAnimator animator = ValueAnimator.ofFloat(mTextSize
                + mDividerHeight, 0.0f);
        animator.setDuration(mAnimationDuration);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mAnimOffset = (Float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }


    private long mNextTime = 0l;
    private boolean mIsEnd = false;
    /**
     * 更新进度
     *
     * @param time
     *            当前时间
     */
    public synchronized void updateTime(long time) {
        // 避免重复绘制
        if (time < mNextTime || mIsEnd) {
            return;
        }
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).getTime() > time) {
                Log.i("LrcView", "newline ...");
                mNextTime = mList.get(i).getTime();
                mCurrentLine = i < 1 ? 0 : i - 1;
                // 属性动画只能在主线程使用，因此用Handler转发操作
                mHandler.sendEmptyMessage(0);
                break;
            } else if (i == mList.size() - 1) {
                // 最后一行
                Log.i("LrcView", "end ...");
                mCurrentLine = mList.size() - 1;
                mIsEnd = true;
                // 属性动画只能在主线程使用，因此用Handler转发操作
                mHandler.sendEmptyMessage(0);
                break;
            }
        }
    }

    public void refreshLcy(){
        mCurrentLine = 0;
        mNextTime = 0;
        mIsEnd = false;
        updateTime(mNextTime);
    }
    private static class LrcHandler extends Handler {
        private WeakReference<LrcView> mLrcViewRef;

        public LrcHandler(WeakReference<LrcView> lrcViewRef) {
            mLrcViewRef = lrcViewRef;
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    LrcView lrcView = mLrcViewRef.get();
                    if (lrcView != null) {
                        lrcView.newLineAnim();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    }
}
