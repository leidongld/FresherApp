package com.example.leidong.fresher.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leidong.fresher.R;

import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/9/24.
 */
public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getSimpleName();

    private View mView;

    @SuppressLint("StaticFieldLeak")
    private static HomeFragment mInstance = null;

    @SuppressLint("ValidFragment")
    private HomeFragment() {

    }

    public static HomeFragment getInstance() {
        if (mInstance == null) {
            synchronized (HomeFragment.class) {
                if (mInstance == null) {
                    mInstance = new HomeFragment();
                }
            }
        }
        return mInstance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
