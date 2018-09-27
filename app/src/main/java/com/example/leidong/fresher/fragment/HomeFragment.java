package com.example.leidong.fresher.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.adapter.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/9/24.
 */
public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getSimpleName();

    private View mView;

    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @BindView(R.id.title1)
    TextView mTitle1;

    @BindView(R.id.title2)
    TextView mTitle2;

    @BindView(R.id.title3)
    TextView mTitle3;

    @BindView(R.id.title4)
    TextView mTitle4;

    private FruitFragment mFruitFragment;

    private VegetableFragment mVegetableFragment;

    private MeatFragment mMeatFragment;

    private GrainFragment mGrainFragment;

    private List<Fragment> mFragmentList;

    private MyFragmentAdapter mMyFragmentAdapter;

    private int mCurrentPage = 0;

    @SuppressLint("StaticFieldLeak")
    private static HomeFragment mInstance = null;

    @SuppressLint("ValidFragment")
    private HomeFragment() {

    }

    public static HomeFragment getInstance() {
        if (mInstance == null) {
            synchronized (HomeFragment.class) {
                if (mInstance == null) {
                    mInstance = new HomeFragment();
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
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    /**
     * 初始化
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void init() {
        mFruitFragment = FruitFragment.getInstance();
        mVegetableFragment = VegetableFragment.getInstance();
        mMeatFragment = MeatFragment.getInstance();
        mGrainFragment = GrainFragment.getInstance();

        mFragmentList = new ArrayList<>();
        mFragmentList.add(mFruitFragment);
        mFragmentList.add(mVegetableFragment);
        mFragmentList.add(mMeatFragment);
        mFragmentList.add(mGrainFragment);

        mMyFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), (ArrayList<Fragment>) mFragmentList);
        mViewPager.setAdapter(mMyFragmentAdapter);
        mViewPager.setCurrentItem(mCurrentPage);
        mTitle1.setTextColor(getResources().getColor(R.color.colorBlue));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mCurrentPage = i;
                if(mCurrentPage == 0) {
                    mTitle1.setTextColor(getResources().getColor(R.color.colorBlue));
                    mTitle2.setTextColor(getResources().getColor(R.color.colorGray));
                    mTitle3.setTextColor(getResources().getColor(R.color.colorGray));
                    mTitle4.setTextColor(getResources().getColor(R.color.colorGray));
                } else if(mCurrentPage == 1) {
                    mTitle1.setTextColor(getResources().getColor(R.color.colorGray));
                    mTitle2.setTextColor(getResources().getColor(R.color.colorBlue));
                    mTitle3.setTextColor(getResources().getColor(R.color.colorGray));
                    mTitle4.setTextColor(getResources().getColor(R.color.colorGray));
                } else if(mCurrentPage == 2) {
                    mTitle1.setTextColor(getResources().getColor(R.color.colorGray));
                    mTitle2.setTextColor(getResources().getColor(R.color.colorGray));
                    mTitle3.setTextColor(getResources().getColor(R.color.colorBlue));
                    mTitle4.setTextColor(getResources().getColor(R.color.colorGray));
                } else {
                    mTitle1.setTextColor(getResources().getColor(R.color.colorGray));
                    mTitle2.setTextColor(getResources().getColor(R.color.colorGray));
                    mTitle3.setTextColor(getResources().getColor(R.color.colorGray));
                    mTitle4.setTextColor(getResources().getColor(R.color.colorBlue));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
