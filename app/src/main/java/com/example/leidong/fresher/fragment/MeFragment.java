package com.example.leidong.fresher.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leidong.fresher.R;

/**
 * Created by Lei Dong on 2018/9/24.
 */
public class MeFragment extends BaseFragment {
    private static final String TAG = MeFragment.class.getSimpleName();

    private View mView;

    @SuppressLint("StaticFieldLeak")
    private static MeFragment mInstance = null;

    @SuppressLint("ValidFragment")
    private MeFragment() {

    }

    public static MeFragment getInstance() {
        if (mInstance == null) {
            synchronized (MeFragment.class) {
                if (mInstance == null) {
                    mInstance = new MeFragment();
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
        mView = inflater.inflate(R.layout.fragment_me, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    /**
     * 全部初始化操作
     */
    @Override
    public void init() {

    }
}
