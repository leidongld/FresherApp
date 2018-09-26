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
public class GrainFragment extends BaseFragment {
    private static final String TAG = GrainFragment.class.getSimpleName();

    private View mView;

    @SuppressLint("StaticFieldLeak")
    private static GrainFragment mInstance = null;

    @SuppressLint("ValidFragment")
    private GrainFragment() {

    }

    public static GrainFragment getInstance() {
        if (mInstance == null) {
            synchronized (GrainFragment.class) {
                if (mInstance == null) {
                    mInstance = new GrainFragment();
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
        mView = inflater.inflate(R.layout.fragment_grain, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
