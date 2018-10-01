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
public class VegetableFragment extends BaseFragment {
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
    private static VegetableFragment mInstance = null;

    @SuppressLint("ValidFragment")
    private VegetableFragment() {

    }

    public static VegetableFragment getInstance() {
        if (mInstance == null) {
            synchronized (VegetableFragment.class) {
                if (mInstance == null) {
                    mInstance = new VegetableFragment();
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
        mProductsTitle.setText("精选蔬菜");

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
                "2",
                "007",
                "玉米",
                "https://img14.360buyimg.com/n1/s150x150_jfs/t5233/203/1231810249/245790/5a58f912/590d1fe7Nca5bfec6.jpg",
                20.00f,
                "玉米"));
        mProductList.add(new Product(
                "2",
                "2",
                "007",
                "小西红柿",
                "https://img11.360buyimg.com/n1/s150x150_jfs/t18214/360/2386198411/293049/11e5e4b1/5af25da3N8e3ececc.jpg",
                30.90f,
                "小西红柿"
        ));
        mProductList.add(new Product(
                "3",
                "2",
                "007",
                "大白菜",
                "https://img11.360buyimg.com/n1/s150x150_jfs/t4048/252/288662110/127744/931a566e/58462cd6N653980df.jpg",
                33.80f,
                "大白菜"
        ));
        mProductList.add(new Product(
                "4",
                "2",
                "007",
                "西蓝花",
                "https://img13.360buyimg.com/n1/s150x150_jfs/t3070/206/5569201132/291320/5944eb12/58748a0fN642a1da3.jpg",
                32.80f,
                "西蓝花"
        ));
        mProductList.add(new Product(
                "5",
                "2",
                "007",
                "小青菜",
                "https://img14.360buyimg.com/n1/s150x150_jfs/t4297/120/375562832/241785/c162c78b/58b3c779Na1ec50a0.jpg",
                32.80f,
                "小青菜"
        ));
        mProductList.add(new Product(
                "6",
                "2",
                "007",
                "黄瓜",
                "https://img10.360buyimg.com/n1/s150x150_jfs/t3892/26/992876975/475076/8bb3ac2f/58661dbaN7998fb64.jpg",
                12.90f,
                "黄瓜"
        ));
        mProductList.add(new Product(
                "7",
                "2",
                "007",
                "马铃薯",
                "https://img10.360buyimg.com/n1/s150x150_jfs/t3460/229/2260622301/57805/cdbdc052/58490b43N01fe973a.jpg",
                16.90f,
                "马铃薯"
        ));
        mProductList.add(new Product(
                "8",
                "2",
                "007",
                "香菇",
                "https://img10.360buyimg.com/n1/s150x150_jfs/t3814/248/1734015788/109979/e4b9c826/583ba9bfN7dc6e700.jpg",
                16.90f,
                "香菇"
        ));
    }

    /**
     * 初始化Banner信息
     */
    private void initBannerData() {
        mBannerList = new ArrayList<>();
        mBannerList.add(new BannerBean("蔬菜沙拉", "https://images.pexels.com/photos/257816/pexels-photo-257816.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("葱蒜", "https://images.pexels.com/photos/159250/bulb-closeup-close-up-clove-159250.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("降血压蔬菜", "https://images.pexels.com/photos/1367243/pexels-photo-1367243.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("胡萝卜", "https://images.pexels.com/photos/162670/carrot-juice-juice-carrots-vegetable-juice-162670.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("甜椒", "https://images.pexels.com/photos/452773/pexels-photo-452773.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
    }
}
