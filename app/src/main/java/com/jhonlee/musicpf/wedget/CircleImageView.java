package com.jhonlee.musicpf.wedget;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;

import com.jhonlee.musicpf.R;

/**
 * Created by JhoneLee on 2017/4/1.
 */

public class CircleImageView extends android.support.v7.widget.AppCompatImageView {

    private Paint paint;

    //外圆的颜色
    private int outCircleColor = getResources().getColor(R.color.colorChecked);
    private int outWidth;
    //view的宽度和高度
    private int width;
    private int height;
    private Bitmap bitmap;
    public CircleImageView(Context context) {
        this(context,null);
    }


    public CircleImageView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context){

            TypedArray array = context.obtainStyledAttributes(R.styleable.CircleImageView);
            outCircleColor = array.getColor(R.styleable.CircleImageView_outColor,getResources()
                    .getColor(R.color.colorChecked));
            outWidth = (int)array.getDimension(R.styleable.CircleImageView_outWidth,1f);
            paint = new Paint();
            paint.setColor(outCircleColor);//颜色
            paint.setAntiAlias(true);//设置抗锯齿
            array.recycle();

    }

    /**
     * 测量宽和高，这一块可以是一个模板代码(Android群英传)
     * @param width
     * @return
     */
    private int measureWith(int width) {
        int result = 0;
        //从MeasureSpec对象中提取出来具体的测量模式和大小
        int mode = MeasureSpec.getMode(width);
        int size = MeasureSpec.getSize(width);
        if (mode == MeasureSpec.EXACTLY) {
            //测量的模式，精确
            result = size;
        } else {
            result = 60;
        }
        return result;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        width = measureWith(widthMeasureSpec)-outWidth*2;
        height = measureWith(heightMeasureSpec)-outWidth*2;
        setMeasuredDimension(width,height);
    }

    private Bitmap creatCircleImg(Bitmap bitmap,int min){
        Bitmap m = null;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        m = Bitmap.createBitmap(min,min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(m);
        canvas.drawCircle(min/2,min/2,min/2,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap,0,0,paint);
        return  m;
    }
    private void LoadImage(){
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.getDrawable();

        if (bitmapDrawable != null) {
            bitmap = bitmapDrawable.getBitmap();
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
            LoadImage();
            if (bitmap!=null){
                int min = Math.min(width,height);
                int circler = min/2;
                bitmap = Bitmap.createScaledBitmap(bitmap,min,min,false);
                canvas.drawCircle(circler+outWidth,circler+outWidth,circler+outWidth,paint);
                canvas.drawBitmap(creatCircleImg(bitmap,min),outWidth,outWidth,null);
            }
    }
}
