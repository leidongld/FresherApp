package com.example.leidong.fresher.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.bean.ShoppingCartItemBean;
import com.example.leidong.fresher.dbbean.Product;
import com.example.leidong.fresher.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Lei Dong on 2018/10/3.
 */
public class ProductActivity extends BaseActivity {
    private static final String TAG = ProductActivity.class.getSimpleName();

    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.title)
    TextView mTitle;

    @BindView(R.id.subtitle)
    TextView mSubTitle;

    @BindView(R.id.price)
    TextView mPrice;

    @BindView(R.id.detail)
    TextView mDetail;

    @BindView(R.id.shoppingcart_layout)
    FrameLayout mShoppingCartLayout;

    @BindView(R.id.number)
    TextView mNumber;

    private List<String> mImageList;

    private Product mProduct = null;

    private ShoppingCartItemBean mShoppingCartItemBean = null;

    private Intent mIntent;

    @Override
    public int setLayout() {
        return R.layout.activity_product;
    }

    @Override
    public boolean setFullScreem() {
        return true;
    }

    @Override
    protected void doBusiness() {
        initDatas();

        configBanner();
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        if(null != mProduct) {
            initProductData();
        }
        if(null != mShoppingCartItemBean) {
            initShoppingcartItemData();
        }

        initBannerData();
    }

    /**
     * 初始化购物车条目数据
     */
    private void initShoppingcartItemData() {
        mTitle.setText(mShoppingCartItemBean.getName());
        mSubTitle.setText(mShoppingCartItemBean.getName());
        mPrice.setText("￥" + mShoppingCartItemBean.getPrice());
        mDetail.setText(mShoppingCartItemBean.getDetail());
    }

    /**
     * 初始化商品数据
     */
    @SuppressLint("SetTextI18n")
    private void initProductData() {
        mTitle.setText(mProduct.getName());
        mSubTitle.setText(mProduct.getName());
        mPrice.setText("￥" + mProduct.getPrice());
        mDetail.setText(mProduct.getDetail());
    }

    /**
     * 初始化Banner数据
     */
    private void initBannerData() {
        mImageList = new ArrayList<>();
        mImageList.add("https://images.pexels.com/photos/42059/citrus-diet-food-fresh-42059.jpeg?auto=compress&cs=tinysrgb&h=350");
        mImageList.add("https://images.pexels.com/photos/65923/orange-food-juicy-fruit-65923.jpeg?auto=compress&cs=tinysrgb&h=350");
        mImageList.add("https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg?auto=compress&cs=tinysrgb&h=350");
    }

    @Override
    protected void initActions() {

    }

    /**
     * 配置Banner信息
     */
    private void configBanner() {
        mBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setImages(mImageList);
        mBanner.setBannerAnimation(Transformer.Accordion);
        mBanner.isAutoPlay(true);
        mBanner.setDelayTime(3000);
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBanner.start();
    }

    @Override
    protected void initWidgets() {
        mIntent = getIntent();
        mProduct = (Product) mIntent.getSerializableExtra("product");
        mShoppingCartItemBean = (ShoppingCartItemBean) mIntent.getSerializableExtra("shoppingcartItem");
    }

    @OnClick(R.id.add_to_shopping_cart)
    void onClickAddToShoppingCart() {
        Toast.makeText(this, "hahaha", Toast.LENGTH_SHORT).show();
    }
}
