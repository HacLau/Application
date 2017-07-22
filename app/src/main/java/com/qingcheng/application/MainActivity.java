package com.qingcheng.application;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import com.qingcheng.application.fragment.CenterFragment;
import com.qingcheng.application.fragment.CommunityFragment;
import com.qingcheng.application.fragment.FabricationFragment;
import com.qingcheng.application.fragment.PublishFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.myCoordinator)
    CoordinatorLayout myCoordinator;
    private BottomBar mBottomBar;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewPager();
        createBottomBar(savedInstanceState);

    }

    private void createBottomBar(Bundle savedInstanceState) {
        mBottomBar = BottomBar.attachShy(myCoordinator, viewPager, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.bottom_bar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.bb_menu_recents:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.bb_menu_favorites:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.bb_menu_nearby:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.bb_menu_friends:
                        viewPager.setCurrentItem(3);
                        break;

                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorNav));
        mBottomBar.mapColorForTab(1, ContextCompat.getColor(this, R.color.colorNav));
        mBottomBar.mapColorForTab(2, ContextCompat.getColor(this, R.color.colorNav));
        mBottomBar.mapColorForTab(3, ContextCompat.getColor(this, R.color.colorNav));
        //mBottomBar.mapColorForTab(4, "#FF9800");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

    private void initViewPager() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new CommunityFragment());
        fragmentList.add(new FabricationFragment());
        fragmentList.add(new PublishFragment());
        fragmentList.add(new CenterFragment());
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomBar.selectTabAtPosition(position, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
       /* mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(R.menu.bottom_bar);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                //单击事件 menuItemId 是 R.menu.bottombar_menu 中 item 的 id

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                //重选事件，当前已经选择了这个，又点了这个tab。微博点击首页刷新页面
            }
        });

        // 当点击不同按钮的时候，设置不同的颜色
        // 可以用以下三种方式来设置颜色.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorNav));
        mBottomBar.mapColorForTab(1, ContextCompat.getColor(this, R.color.colorNav));
        mBottomBar.mapColorForTab(2, "#008FB2");
        mBottomBar.mapColorForTab(3, "#008FB2");
        *//*mBottomBar.mapColorForTab(4, "#FF9800");*//*
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //保存BottomBar的状态
        mBottomBar.onSaveInstanceState(outState);
    }
}*/




