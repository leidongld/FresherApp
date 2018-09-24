package com.example.leidong.fresher.ui;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.leidong.fresher.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.rg_button_tag)
    RadioGroup mTagsRg;

    @BindView(R.id.rbt_home)
    RadioButton mHomeRbt;

    @BindView(R.id.rbt_collection)
    RadioButton mCollectionRbt;

    @BindView(R.id.rbt_shopping_cart)
    RadioButton mShoppingCartRbt;

    @BindView(R.id.rbt_me)
    RadioButton mMeRbt;

    /**
     * 设置布局
     *
     * @return
     */
    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    /**
     * 设置是否全屏显示
     *
     * @return
     */
    @Override
    public boolean setFullScreem() {
        return true;
    }

    /**
     * 业务逻辑
     */
    @Override
    protected void doBusiness() {

    }

    /**
     * 初始化动作
     */
    @Override
    protected void initActions() {

    }

    /**
     * 初始化组件
     */
    @Override
    protected void initWidgets() {

    }

    /**
     * 点击主页
     */
    @OnClick(R.id.rbt_home)
    void onClickHome() {
        Toast.makeText(this, "点击主页", Toast.LENGTH_LONG).show();
    }

    /**
     * 点击精选
     */
    @OnClick(R.id.rbt_collection)
    void onClickCollection() {
        Toast.makeText(this, "点击精选", Toast.LENGTH_LONG).show();
    }

    /**
     * 点击购物车
     */
    @OnClick(R.id.rbt_shopping_cart)
    void onClickShoppingCart() {
        Toast.makeText(this, "点击购物车", Toast.LENGTH_LONG).show();
    }

    /**
     * 点击我的
     */
    @OnClick(R.id.rbt_me)
    void onClickMe() {
        Toast.makeText(this, "点击我的", Toast.LENGTH_LONG).show();
    }
}
