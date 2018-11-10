package com.example.leidong.fresher.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.leidong.fresher.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/9/24.
 */
public class CollectionFragment extends BaseFragment {
    private static final String TAG = CollectionFragment.class.getSimpleName();

    private View mView;

    @BindView(R.id.image1)
    ImageView mImage1;

    @BindView(R.id.image2)
    ImageView mImage2;

    @BindView(R.id.image3)
    ImageView mImage3;

    @BindView(R.id.image4)
    ImageView mImage4;

    @BindView(R.id.icon_fruit)
    ImageView mIconFruit;

    @BindView(R.id.icon_vegetable)
    ImageView mIconVegetable;

    @BindView(R.id.icon_meat)
    ImageView mIconMeat;

    @BindView(R.id.icon_grain)
    ImageView mIconGrain;

    @SuppressLint("StaticFieldLeak")
    private static CollectionFragment mInstance = null;

    @SuppressLint("ValidFragment")
    private CollectionFragment() {

    }

    public static CollectionFragment getInstance() {
        if (mInstance == null) {
            synchronized (CollectionFragment.class) {
                if (mInstance == null) {
                    mInstance = new CollectionFragment();
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
        mView = inflater.inflate(R.layout.fragment_cellection, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();

    }

    /**
     * 全部的初始化操作
     */
    @Override
    public void init() {
        initDatas();

        configImages();
    }

    /**
     * 配置上方的四张图片
     */
    private void configImages() {
        Glide.with(getActivity()).load("https://images.pexels.com/photos/936611/pexels-photo-936611.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350").into(mImage1);
        Glide.with(getActivity()).load("https://images.pexels.com/photos/1028599/pexels-photo-1028599.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350").into(mImage2);
        Glide.with(getActivity()).load("https://images.pexels.com/photos/1099680/pexels-photo-1099680.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350").into(mImage3);
        Glide.with(getActivity()).load("https://images.pexels.com/photos/461295/pexels-photo-461295.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350").into(mImage4);
    }

    /**
     * 初始化数据
     */
    private void initDatas() {

    }
}
