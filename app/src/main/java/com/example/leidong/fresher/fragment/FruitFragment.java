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
public class FruitFragment extends BaseFragment {
    private static final String TAG = FruitFragment.class.getSimpleName();

    private Context mContext;

    private View mView;

    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.recyclerView)
    RecyclerView mFruitsView;

    List<BannerBean> mBannerList;

    List<Product> mProductList;

    private ProductsAdapter mProductsAdapter;

    @SuppressLint("StaticFieldLeak")
    private static FruitFragment mInstance = null;

    @SuppressLint("ValidFragment")
    private FruitFragment() {

    }

    public static FruitFragment getInstance() {
        if (mInstance == null) {
            synchronized (FruitFragment.class) {
                if (mInstance == null) {
                    mInstance = new FruitFragment();
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
        mView = inflater.inflate(R.layout.fragment_fruit, container, false);
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
                "1",
                "007",
                "爱奇果",
                "https://img11.360buyimg.com/n2/jfs/t7873/88/958332640/139857/953e9bc8/599936e5Nb3919bd8.jpg",
                20.00f,
                "陕西眉县 徐香猕猴桃 15个 单果约80~100g"));
        mProductList.add(new Product(
                "2",
                "1",
                "007",
                "丑柑",
                "https://img10.360buyimg.com/n2/jfs/t18676/183/164078159/297786/ea024d8b/5a607804Nae627ab7.jpg",
                30.90f,
                "丑柑 2kg装 单果150~200g"
        ));
        mProductList.add(new Product(
                "3",
                "1",
                "007",
                "苹果",
                "https://img11.360buyimg.com/n2/jfs/t9736/130/2196424951/348309/9e6d671c/59f1a5e3Nf3aa9d8c.jpg",
                33.80f,
                "陕西白水红富士苹果12个 果径70~75mm 总重约2kg"
        ));
        mProductList.add(new Product(
                "4",
                "1",
                "007",
                "蜜柚",
                "https://img14.360buyimg.com/n2/jfs/t3220/28/2650111828/190096/d36bddd4/57e4c912Nf23ee79b.jpg",
                32.80f,
                "特级君溪蜜柚 鸳鸯柚子2粒装 1粒红肉加1粒白肉"
        ));
        mProductList.add(new Product(
                "5",
                "1",
                "007",
                "香梨",
                "https://img11.360buyimg.com/n2/jfs/t8212/335/867296173/346941/42857e6f/59b0afceNd7a1adfa.jpg",
                32.80f,
                "特级库尔勒香梨 单果120~150g 总重量约2.5kg"
        ));
        mProductList.add(new Product(
                "6",
                "1",
                "007",
                "柠檬",
                "https://img11.360buyimg.com/n1/s160x160_jfs/t3073/126/4493743873/517871/e97991e3/5847bf31N86100938.jpg",
                12.90f,
                "黄柠檬4颗"
        ));
        mProductList.add(new Product(
                "7",
                "1",
                "007",
                "小青柠",
                "https://img13.360buyimg.com/n1/s150x150_jfs/t21670/176/97796296/369105/9712110a/5afbd8c3N19b5de1b.jpg",
                16.90f,
                "海南小青柠"
        ));
    }

    /**
     * 初始化Banner信息
     */
    private void initBannerData() {
        mBannerList = new ArrayList<>();
        mBannerList.add(new BannerBean("蓝莓", "https://images.pexels.com/photos/70862/pexels-photo-70862.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("西瓜", "https://images.pexels.com/photos/1068534/pexels-photo-1068534.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("橘子", "https://images.pexels.com/photos/207085/pexels-photo-207085.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("牛油果", "https://images.pexels.com/photos/557659/pexels-photo-557659.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mBannerList.add(new BannerBean("葡萄", "https://images.pexels.com/photos/197907/pexels-photo-197907.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
    }
}
