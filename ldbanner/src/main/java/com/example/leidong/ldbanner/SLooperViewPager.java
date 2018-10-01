package com.example.leidong.ldbanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lei Dong on 2018/9/28.
 */
public class SLooperViewPager extends ViewPager {
    private SLooperAdapter mAdapter;
    private List<OnPageChangeListener> mOnPageChangeListeners;

    public SLooperViewPager(@NonNull Context context) {
        this(context, null);
    }

    public SLooperViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        if (mOnPageChangeListeners != null) {
            super.removeOnPageChangeListener((OnPageChangeListener) mOnPageChangeListeners);
        }
        super.addOnPageChangeListener((OnPageChangeListener) mOnPageChangeListeners);
    }

    @Override
    public void setAdapter(@Nullable PagerAdapter adapter) {
        super.setAdapter(adapter);
        mAdapter = new SLooperAdapter(adapter);
        setCurrentItem(0, false);
    }

    @Nullable
    @Override
    public PagerAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void setCurrentItem(int item) {
        setCurrentItem(item, true);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(mAdapter.toLooperPosition(item), smoothScroll);
    }

    @Override
    public int getCurrentItem() {
        return mAdapter.getInnerAdapterPosition(super.getCurrentItem());
    }

    @Override
    public void clearOnPageChangeListeners() {
        if (mOnPageChangeListeners != null) {
            mOnPageChangeListeners.clear();
        }
    }

    @Override
    public void removeOnPageChangeListener(@NonNull OnPageChangeListener listener) {
        if (mOnPageChangeListeners != null) {
            mOnPageChangeListeners.remove(listener);
        }
    }

    @Override
    public void addOnPageChangeListener(@NonNull OnPageChangeListener listener) {
        if (mOnPageChangeListeners == null) {
            mOnPageChangeListeners = new ArrayList<>();
        }
        mOnPageChangeListeners.add(listener);
    }

    private OnPageChangeListener mOnPageChangeListener = new OnPageChangeListener() {
        private float mPreviousOffset = -1;
        private float mPreviousPosition = -1;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (mAdapter != null) {
                int innerPosition = mAdapter.getInnerAdapterPosition(position);

                if (positionOffset == 0 && mPreviousOffset == 0 && (position == 0 || position == mAdapter.getCount() - 1)) {
                    setCurrentItem(innerPosition, false);
                }

                mPreviousOffset = positionOffset;

                if (mOnPageChangeListeners != null) {
                    for (int i = 0; i < mOnPageChangeListeners.size(); i++) {
                        OnPageChangeListener listener = mOnPageChangeListeners.get(i);
                        if (listener != null) {
                            if (innerPosition != mAdapter.getInnerCount() - 1) {
                                listener.onPageScrolled(innerPosition, positionOffset, positionOffsetPixels);
                            } else {
                                if(positionOffset > 0.5) {
                                    listener.onPageScrolled(0, 0, 0);
                                } else {
                                    listener.onPageScrolled(innerPosition, 0, 0);
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void onPageSelected(int position) {
            int realPosition = mAdapter.getInnerAdapterPosition(position);
            if (mPreviousPosition != realPosition) {
                mPreviousPosition = realPosition;
                if (mOnPageChangeListeners != null) {
                    for (int i = 0; i < mOnPageChangeListeners.size(); i++) {
                        OnPageChangeListener listener = mOnPageChangeListeners.get(i);
                        if (listener != null) {
                            listener.onPageSelected(realPosition);
                        }
                    }
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (mAdapter != null) {
                int position = SLooperViewPager.super.getCurrentItem();
                int realPosition = mAdapter.getInnerAdapterPosition(position);
                if (state == ViewPager.SCROLL_STATE_IDLE && (position == 0 || position == mAdapter.getCount() - 1)) {
                    setCurrentItem(realPosition, false);
                }
            }
            if (mOnPageChangeListeners != null) {
                for (int i = 0; i < mOnPageChangeListeners.size(); i++) {
                    OnPageChangeListener listener = mOnPageChangeListeners.get(i);
                    if (listener != null) {
                        listener.onPageScrollStateChanged(state);
                    }
                }
            }
        }
    };

}
