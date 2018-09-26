package com.example.leidong.fresher.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.fragment.CollectionFragment;
import com.example.leidong.fresher.fragment.HomeFragment;
import com.example.leidong.fresher.fragment.MeFragment;
import com.example.leidong.fresher.fragment.ShoppingCartFragment;

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

    @BindView(R.id.container)
    LinearLayout mContainer;

    private FragmentManager mFragmentManager;

    private FragmentTransaction mFragmentTransaction;

    private HomeFragment mHomeFragment;

    private CollectionFragment mCollectionFragment;

    private ShoppingCartFragment mShoppingCartFragment;

    private MeFragment mMeFragment;

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
        mTagsRg.check(R.id.rbt_home);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mHomeFragment = HomeFragment.getInstance();
        mFragmentTransaction.replace(R.id.container, mHomeFragment);
        mFragmentTransaction.commit();
    }

    /**
     * 点击主页
     */
    @OnClick(R.id.rbt_home)
    void onClickHome() {
        Toast.makeText(this, "点击主页", Toast.LENGTH_LONG).show();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mHomeFragment = HomeFragment.getInstance();
        mFragmentTransaction.replace(R.id.container, mHomeFragment);
        mFragmentTransaction.commit();
    }

    /**
     * 点击精选
     */
    @OnClick(R.id.rbt_collection)
    void onClickCollection() {
        Toast.makeText(this, "点击精选", Toast.LENGTH_LONG).show();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mCollectionFragment = CollectionFragment.getInstance();
        mFragmentTransaction.replace(R.id.container, mCollectionFragment);
        mFragmentTransaction.commit();
    }

    /**
     * 点击购物车
     */
    @OnClick(R.id.rbt_shopping_cart)
    void onClickShoppingCart() {
        Toast.makeText(this, "点击购物车", Toast.LENGTH_LONG).show();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mShoppingCartFragment = ShoppingCartFragment.getInstance();
        mFragmentTransaction.replace(R.id.container, mShoppingCartFragment);
        mFragmentTransaction.commit();
    }

    /**
     * 点击我的
     */
    @OnClick(R.id.rbt_me)
    void onClickMe() {
        Toast.makeText(this, "点击我的", Toast.LENGTH_LONG).show();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mMeFragment = MeFragment.getInstance();
        mFragmentTransaction.replace(R.id.container, mMeFragment);
        mFragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTagsRg.check(R.id.rbt_home);
    }
}
