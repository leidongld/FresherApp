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
public class MeatFragment extends BaseFragment {
    private static final String TAG = MeatFragment.class.getSimpleName();

    private View mView;

    @SuppressLint("StaticFieldLeak")
    private static MeatFragment mInstance = null;

    @SuppressLint("ValidFragment")
    private MeatFragment() {

    }

    public static MeatFragment getInstance() {
        if (mInstance == null) {
            synchronized (MeatFragment.class) {
                if (mInstance == null) {
                    mInstance = new MeatFragment();
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
        mView = inflater.inflate(R.layout.fragment_meat, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
