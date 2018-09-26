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
public class ShoppingCartFragment extends BaseFragment {
    private static final String TAG = ShoppingCartFragment.class.getSimpleName();

    private View mView;

    @SuppressLint("StaticFieldLeak")
    private static ShoppingCartFragment mInstance = null;

    @SuppressLint("ValidFragment")
    private ShoppingCartFragment() {

    }

    public static ShoppingCartFragment getInstance() {
        if (mInstance == null) {
            synchronized (ShoppingCartFragment.class) {
                if (mInstance == null) {
                    mInstance = new ShoppingCartFragment();
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
        mView = inflater.inflate(R.layout.fragment_shoppingcart, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
