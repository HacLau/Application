package com.qingcheng.application.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qingcheng.application.R;

/**
 * Created by Administrator on 2017/6/20.
 */
public class PublishFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.publish, container, false);
    }
}
