package com.example.leidong.ldbanner;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lei Dong on 2018/9/28.
 */
public class SLooperAdapter extends PagerAdapter {
    private PagerAdapter mPagerAdapter;

    public SLooperAdapter(PagerAdapter mPagerAdapter) {
        this.mPagerAdapter = mPagerAdapter;
    }

    @Override
    public int getCount() {
        return mPagerAdapter.getCount() <= 1 ? mPagerAdapter.getCount() : mPagerAdapter.getCount() + 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return mPagerAdapter.isViewFromObject(view, o);
    }

    @Override
    public void startUpdate(@NonNull ViewGroup container) {
        mPagerAdapter.startUpdate(container);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return mPagerAdapter.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        mPagerAdapter.destroyItem(container, position, object);
    }

    @Override
    public void finishUpdate(@NonNull ViewGroup container) {
        mPagerAdapter.finishUpdate(container);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    /**
     * 根据外层是position获取内层position
     *
     * @param position
     * @return
     */
    int getInnerAdapterPosition(int position) {
        int realCount = getInnerCount();
        if (realCount == 0) {
            return 0;
        }
        int realPosition = (position - 1) % realCount;
        if(realCount < 0) {
            realPosition += realCount;
        }
        return realPosition;
    }

    int getInnerCount() {
        return mPagerAdapter.getCount();
    }

    /**
     * 根据内层position的位置，返回映射后外层position的位置
     *
     * @param position
     * @return
     */
    int toLooperPosition(int position) {
        if(getInnerCount() > 1) {
            return position + 1;
        }
        return position;
    }
}
