package com.qingcheng.application.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.qingcheng.application.R;

/**
 * Created by Administrator on 2017/6/20.
 */
public class CommunityFragment extends Fragment{
    private RollPagerView mRollViewPager;
    private Context context = getActivity();
    private int startX;

    private int width;
    private int height;


   // private ImageList<Integer> images=new ImageList<Integer>(){R.mipmap.banner_do,R.mipmap.banner_advantage,R.mipmap.banner_information,R.mipmap.banner_start_line};
    //Integer[] images={R.mipmap.banner_do,R.mipmap.banner_advantage,R.mipmap.banner_information,R.mipmap.banner_start_line};
    //private List<Bitmap> mImage = new ArrayList<Bitmap>(){R.mipmap.banner_do,R.mipmap.banner_advantage,R.mipmap.banner_information,R.mipmap.banner_start_line};
    //private List<String> mTitle = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.community, container, false);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        width = dm.widthPixels;
        height = dm.heightPixels;

        mRollViewPager = (RollPagerView) view.findViewById(R.id.roll_view_pager);
        //设置播放时间间隔
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) mRollViewPager.getLayoutParams();
        //获取当前控件的布局对象
        params.height= width * 9 / 16;//设置当前控件布局的高度
        mRollViewPager.setLayoutParams(params);//将设置好的布局参数应用到控件中

        mRollViewPager.setPlayDelay(3000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
        mRollViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        startX = (int) event.getX();
                        Toast.makeText(context, mRollViewPager.getDisplay().getDisplayId() + "", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }

                return false;
            }
        });
        return view;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.mipmap.banner_do,
                R.mipmap.banner_advantage,
                R.mipmap.banner_information,
                R.mipmap.banner_start_line
        };


        @Override
        public View getView(ViewGroup container, int position) {

            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }



}
