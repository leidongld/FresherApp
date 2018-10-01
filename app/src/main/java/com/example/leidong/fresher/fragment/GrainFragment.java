package com.example.leidong.fresher.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.adapter.ProductsAdapter;
import com.example.leidong.fresher.bean.BannerBean;
import com.example.leidong.fresher.dbbean.Product;
import com.example.leidong.fresher.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/9/24.
 */
public class GrainFragment extends BaseFragment {
    private static final String TAG = VegetableFragment.class.getSimpleName();

    private Context mContext;

    private View mView;

    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.recyclerView)
    RecyclerView mFruitsView;

    @BindView(R.id.products_title)
    TextView mProductsTitle;

    List<BannerBean> mBannerList;

    List<Product> mProductList;

    private ProductsAdapter mProductsAdapter;

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

        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initDatas();

        configBanner();

        configFruitsView();
    }

    /**
     * 配置水果列表
     */
    private void configFruitsView() {
        mProductsAdapter = new ProductsAdapter(mContext, mProductList);
        mFruitsView.setLayoutManager(new GridLayoutManager(mContext, 2));
        mFruitsView.setAdapter(mProductsAdapter);
    }

    /**
     * 配置Banner
     */
    private void configBanner() {
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setImages(BannerBean.getBannerImagesList(mBannerList));
        mBanner.setBannerAnimation(Transformer.DepthPage);
        mBanner.setBannerTitles(BannerBean.getBannerTitlesList(mBannerList));
        mBanner.isAutoPlay(true);
        mBanner.setDelayTime(3000);
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBanner.start();
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        mProductsTitle.setText("精选杂粮");

        initBannerData();

        initProductData();
    }

    /**
     * 初始化产品数据
     */
    private void initProductData() {
        mProductList = new ArrayList<>();
        mProductList.add(new Product(
                "1",
                "4",
                "007",
                "相思莲子",
                "https://img10.360buyimg.com/n1/s150x150_jfs/t17473/76/882341747/356605/8206affe/5aaf636eNb64f770f.jpg",
                20.00f,
                "相思莲子"));
        mProductList.add(new Product(
                "2",
                "4",
                "007",
                "紫糯米",
                "https://img11.360buyimg.com/n1/s150x150_jfs/t18949/93/2205716182/617925/840294fa/5aed47b1Ncfc08839.jpg",
                30.90f,
                "紫糯米"
        ));
        mProductList.add(new Product(
                "3",
                "4",
                "007",
                "赤小豆",
                "https://img12.360buyimg.com/n1/s150x150_jfs/t20101/152/1940451602/471707/26702a2c/5b2b15a0Ndafe3fc6.jpg",
                33.80f,
                "赤小豆"
        ));
        mProductList.add(new Product(
                "4",
                "4",
                "007",
                "黄小米",
                "https://img12.360buyimg.com/n1/s150x150_jfs/t21340/193/1433167306/426974/69a4c992/5b28a5faN39e53e3d.jpg",
                32.80f,
                "黄小米"
        ));
        mProductList.add(new Product(
                "5",
                "4",
                "007",
                "燕麦米",
                "https://img12.360buyimg.com/n1/s150x150_jfs/t19702/103/2029817938/399779/c94f5e79/5ae27f3aNf98303df.jpg",
                32.80f,
                "燕麦米"
        ));
        mProductList.add(new Product(
                "6",
                "4",
                "007",
                "糙米",
                "https://img10.360buyimg.com/n1/s150x150_jfs/t17818/262/933471976/386538/1c6fa7e2/5ab1d020N28e328af.jpg",
                12.90f,
                "糙米"
        ));
        mProductList.add(new Product(
                "7",
                "4",
                "007",
                "黑豆",
                "https://img10.360buyimg.com/n1/s150x150_jfs/t19684/297/1961819069/348443/ae932cae/5adef754Nd010756d.jpg",
                16.90f,
                "黑豆"
        ));
    }

    /**
     * 初始化Banner信息
     */
    private void initBannerData() {
        mBannerList = new ArrayList<>();
        mBannerList.add(new BannerBean("小麦", "https://images.pexels.com/photos/265216/pexels-photo-265216.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("燕麦", "https://images.pexels.com/photos/575822/pexels-photo-575822.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("什锦杂粮", "https://images.pexels.com/photos/1306548/pexels-photo-1306548.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("美味面包", "https://images.pexels.com/photos/2434/bread-food-healthy-breakfast.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("咖啡豆", "https://images.pexels.com/photos/296287/pexels-photo-296287.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
    }
}
