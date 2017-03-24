package com.jhonlee.musicpf.view.yueku;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.jhonlee.musicpf.R;
import com.jhonlee.musicpf.listener.PlayListListener;
import com.jhonlee.musicpf.mvp.contract.PlayListContract;
import com.jhonlee.musicpf.mvp.presenter.PlayListPrestenter;
import com.jhonlee.musicpf.pojo.PlayList;
import com.jhonlee.musicpf.util.Dip2pxUtil;
import com.jhonlee.musicpf.view.detail.PlayListDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public class YueKuFragment extends Fragment implements PlayListListener {

    @BindView(R.id.rollpager)
    ViewPager rollpager;
    @BindView(R.id.linear)
    LinearLayout linear;
    @BindView(R.id.linear_gs)
    LinearLayout linearGs;
    @BindView(R.id.linear_mrtj)
    LinearLayout linearMrtj;
    @BindView(R.id.linear_zj)
    LinearLayout linearZj;
    @BindView(R.id.recycler_tjgd)
    RecyclerView recyclerTjgd;
    @BindView(R.id.recycler_rmdt)
    RecyclerView recyclerRmdt;
    @BindView(R.id.recycler_zxph)
    RecyclerView recyclerZxph;

    private YKLBAdapter lbadapter;

    private YueKuRecyclerAdapter tjadapter;
    private YueKuRecyclerAdapter dtadapter;
    private YueKuRecyclerAdapter phadapter;

    private PlayListContract.Presenter lbpresenter;
    private PlayListContract.Presenter tjpresenter;
    private PlayListContract.Presenter dtpresenter;
    private PlayListContract.Presenter phpresenter;

    private List<PlayList.PlaylistBean> tjlists;
    private List<PlayList.PlaylistBean> dtlists;
    private List<PlayList.PlaylistBean> phlists;

    //轮播list
    private List<View> views;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yueku, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @OnClick({R.id.linear_gs,R.id.linear_mrtj,R.id.linear_zj})
    public void Click(View view){
        switch (view.getId()){
            case R.id.linear_zj:
                break;
            case R.id.linear_gs:
                break;
            case R.id.linear_mrtj:
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    private void initViewPagerLunBo(List<PlayList.PlaylistBean> lblists){
        views.clear();
        linear.removeAllViews();
        for (PlayList.PlaylistBean bean : lblists){
            ImageView imagedot = new ImageView(getContext());
            imagedot.setImageResource(R.drawable.shap_circle_dot);
            imagedot.setPadding(Dip2pxUtil.dip2px(getContext(), 3), Dip2pxUtil.dip2px(getContext(), 3), Dip2pxUtil.dip2px(getContext(), 3), Dip2pxUtil.dip2px(getContext(), 3));
            linear.addView(imagedot);
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(getContext()).load(bean.getCoverImgUrl()).into(imageView);
            views.add(imageView);
        }
        lbadapter = new YKLBAdapter(views);
        rollpager.setAdapter(lbadapter);
        //轮播
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                currentIndex++;
                handler.sendEmptyMessage(0);
                handler.postDelayed(this, 5000);
            }
        }, 5000);
        //轮播时 图片移动动画
        rollpager.setPageTransformer(true, new ViewPager.PageTransformer() {
            private float MIN_SCALE = 0.85f;

            private float MIN_ALPHA = 0.5f;

            @Override
            public void transformPage(View view, float position) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();

                if (position < -1) {
                    view.setAlpha(0);
                } else if (position <= 1) {
                    float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                    view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)
                            / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
                } else {
                    view.setAlpha(0);
                }
            }
        });
        //当前图片选中时
        rollpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                currentIndex = position;
                handler.sendEmptyMessage(0);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private int currentIndex = 0;
    //更新界面的效果
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (currentIndex == views.size()) {
                currentIndex = 0;
            }
            rollpager.setCurrentItem(currentIndex);
            for (int i = 0; i < linear.getChildCount(); i++) {
                ImageView imageView = (ImageView) linear.getChildAt(i);
                if (currentIndex == i) {
                    imageView.setImageResource(R.drawable.shap_circle_dot_checked);
                } else {
                    imageView.setImageResource(R.drawable.shap_circle_dot);
                }
                final int finalI = i;
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentIndex = finalI;
                        handler.sendEmptyMessage(0);
                    }
                });

            }
        }
    };

    private void initData(){

        views =new ArrayList<>();
        //轮播数据
        lbpresenter = new PlayListPrestenter();
        lbpresenter.attachView(lbView);
        lbpresenter.loadPlayLists("华语",1000,6);

        LinearLayoutManager managertj = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        tjlists =new ArrayList<>();
        tjadapter = new YueKuRecyclerAdapter(tjlists,getContext(),this);
        tjpresenter = new PlayListPrestenter();
        tjpresenter.attachView(tjView);
        tjpresenter.loadPlayLists("推荐",1000,10);
        recyclerTjgd.setLayoutManager(managertj);
        recyclerTjgd.setAdapter(tjadapter);

        LinearLayoutManager managerdt = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        dtlists =new ArrayList<>();
        dtadapter = new YueKuRecyclerAdapter(dtlists,getContext(),this);
        dtpresenter = new PlayListPrestenter();
        dtpresenter.attachView(dtView);
        dtpresenter.loadPlayLists("热门电台",1000,10);
        recyclerRmdt.setLayoutManager(managerdt);
        recyclerRmdt.setAdapter(dtadapter);

        LinearLayoutManager managerph = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        phlists =new ArrayList<>();
        phadapter = new YueKuRecyclerAdapter(phlists,getContext(),this);
        phpresenter = new PlayListPrestenter();
        phpresenter.attachView(phView);
        phpresenter.loadPlayLists("排行",1000,10);
        recyclerZxph.setLayoutManager(managerph);
        recyclerZxph.setAdapter(phadapter);
    }

    private PlayListContract.View tjView = new PlayListContract.View() {
        @Override
        public void loadPlayLists(List<PlayList.PlaylistBean> list) {
            if (list.size()>0){
                tjlists.clear();
                tjlists.addAll(list);
                tjadapter.notifyDataSetChanged();
            }
        }
    };
    private PlayListContract.View phView = new PlayListContract.View() {
        @Override
        public void loadPlayLists(List<PlayList.PlaylistBean> list) {
            if (list.size()>0){
                phlists.clear();
                phlists.addAll(list);
                phadapter.notifyDataSetChanged();
            }
        }
    };
    private PlayListContract.View dtView = new PlayListContract.View() {
        @Override
        public void loadPlayLists(List<PlayList.PlaylistBean> list) {
            if (list.size()>0){
                dtlists.clear();
                dtlists.addAll(list);
                dtadapter.notifyDataSetChanged();
            }
        }
    };

    private PlayListContract.View lbView = new PlayListContract.View() {
        @Override
        public void loadPlayLists(List<PlayList.PlaylistBean> list) {
            initViewPagerLunBo(list);
            handler.sendEmptyMessage(0);
        }
    };

    @Override
    public void showDetailSong(String url, int id,String name) {
        Intent intent = new Intent(getContext(), PlayListDetailActivity.class);
        intent.putExtra("imgUrl",url);
        intent.putExtra("name",name);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
