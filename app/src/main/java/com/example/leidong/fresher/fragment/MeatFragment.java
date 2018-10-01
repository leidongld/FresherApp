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
public class MeatFragment extends BaseFragment {
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
        mProductsTitle.setText("该吃肉了");

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
                "3",
                "007",
                "澳洲牛排",
                "https://img12.360buyimg.com/n1/s150x150_jfs/t19516/328/1036862922/243826/9b389547/5ab89576Nf57a7873.jpg",
                20.00f,
                "澳洲牛排"));
        mProductList.add(new Product(
                "2",
                "3",
                "007",
                "巴西牛腩",
                "https://img13.360buyimg.com/n1/s150x150_jfs/t20905/215/2540075267/273404/25d0b834/5b5ad137N25093a85.jpg",
                30.90f,
                "巴西牛腩"
        ));
        mProductList.add(new Product(
                "3",
                "3",
                "007",
                "新西兰羊后腿",
                "https://img12.360buyimg.com/n1/s150x150_jfs/t7702/160/435129515/80713/70a7322f/5992ab74Nb3116037.jpg",
                33.80f,
                "新西兰羊后腿"
        ));
        mProductList.add(new Product(
                "4",
                "3",
                "007",
                "法式羊排",
                "https://img11.360buyimg.com/n2/jfs/t5644/353/3534332129/134060/3210c288/593defb6N9dc7c9c3.jpg",
                32.80f,
                "法式羊排"
        ));
        mProductList.add(new Product(
                "5",
                "3",
                "007",
                "羔羊寸排",
                "https://img12.360buyimg.com/n2/jfs/t14749/35/154697575/127852/8708d60a/5a250ef3N4025b108.jpg",
                32.80f,
                "羔羊寸排"
        ));
        mProductList.add(new Product(
                "6",
                "3",
                "007",
                "丹麦三文鱼",
                "https://img11.360buyimg.com/n1/s160x160_jfs/t11827/92/1642408659/433728/dd0b27c/5a054f0eN8d191fdb.jpg",
                12.90f,
                "丹麦三文鱼"
        ));
        mProductList.add(new Product(
                "7",
                "3",
                "007",
                "大黄鱼",
                "https://img14.360buyimg.com/n1/s160x160_jfs/t3100/48/7850659837/85041/f8c8675d/58bd0abfN025b94cd.jpg",
                16.90f,
                "大黄鱼"
        ));
    }

    /**
     * 初始化Banner信息
     */
    private void initBannerData() {
        mBannerList = new ArrayList<>();
        mBannerList.add(new BannerBean("烤牛排", "https://images.pexels.com/photos/1105325/bbq-meet-eating-diner-1105325.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("牛腩饭", "https://images.pexels.com/photos/209459/pexels-photo-209459.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("牛肉汉堡", "https://images.pexels.com/photos/156114/pexels-photo-156114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("爱上吃鸡", "https://images.pexels.com/photos/616354/pexels-photo-616354.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("烤串诱惑", "https://images.pexels.com/photos/1390564/pexels-photo-1390564.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
    }
}
