package com.example.leidong.fresher.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.adapter.ShoppingCartAdapter;
import com.example.leidong.fresher.bean.ShoppingCartItemBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/9/24.
 */
public class ShoppingCartFragment extends BaseFragment {
    private static final String TAG = ShoppingCartFragment.class.getSimpleName();

    private View mView;

    private Context mContext;

    private ArrayList<ShoppingCartItemBean> mShoppingCartItemList = new ArrayList<>();

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    @BindView(R.id.totalPrice)
    TextView mTotalPrice;

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

        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_shoppingcart, container, false);
        ButterKnife.bind(this, mView);
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
        initDatas();

        configList();

        calculateTotalPrice();
    }

    /**
     * 计算商品总价
     */
    private void calculateTotalPrice() {
        float totalPrice = 0f;
        if (mShoppingCartItemList.size() > 0) {
            for (int i = 0; i < mShoppingCartItemList.size(); i++) {
                float price = mShoppingCartItemList.get(i).getPrice();
                int number = mShoppingCartItemList.get(i).getNumber();
                totalPrice += price * number;
            }
        }
        mTotalPrice.setText(totalPrice + " 元");
    }


    /**
     * 配置RecyclerList
     */
    private void configList() {
        ShoppingCartAdapter shopingCarrtAdapter = new ShoppingCartAdapter(mContext, mShoppingCartItemList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(shopingCarrtAdapter);
    }

    /**
     * 获取数据
     */
    private void initDatas() {
        mShoppingCartItemList.add(new ShoppingCartItemBean(
                "1",
                "1",
                "007",
                "爱奇果",
                "https://img11.360buyimg.com/n2/jfs/t7873/88/958332640/139857/953e9bc8/599936e5Nb3919bd8.jpg",
                20.00f,
                3,
                "陕西眉县 徐香猕猴桃 15个 单果约80~100g"));
        mShoppingCartItemList.add(new ShoppingCartItemBean(
                "2",
                "1",
                "007",
                "丑柑",
                "https://img10.360buyimg.com/n2/jfs/t18676/183/164078159/297786/ea024d8b/5a607804Nae627ab7.jpg",
                30.90f,
                1,
                "丑柑 2kg装 单果150~200g"
        ));
        mShoppingCartItemList.add(new ShoppingCartItemBean(
                "3",
                "1",
                "007",
                "苹果",
                "https://img11.360buyimg.com/n2/jfs/t9736/130/2196424951/348309/9e6d671c/59f1a5e3Nf3aa9d8c.jpg",
                33.80f,
                7,
                "陕西白水红富士苹果12个 果径70~75mm 总重约2kg"
        ));
        mShoppingCartItemList.add(new ShoppingCartItemBean(
                "4",
                "1",
                "007",
                "蜜柚",
                "https://img14.360buyimg.com/n2/jfs/t3220/28/2650111828/190096/d36bddd4/57e4c912Nf23ee79b.jpg",
                32.80f,
                2,
                "特级君溪蜜柚 鸳鸯柚子2粒装 1粒红肉加1粒白肉"
        ));
    }
}
