package com.example.leidong.fresher.ui;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.leidong.fresher.R;
import com.example.leidong.fresher.bean.BannerBean;

import butterknife.BindView;

/**
 * Created by Lei Dong on 2018/10/14.
 */
public class BannerActivity extends BaseActivity {
    private static final String TAG = BannerActivity.class.getSimpleName();

    @BindView(R.id.image)
    ImageView mImage;

    @BindView(R.id.title)
    TextView mTitle;

    @BindView(R.id.author)
    TextView mAuthor;

    @BindView(R.id.detail)
    TextView mDetail;

    private BannerBean mBanner;

    @Override
    public int setLayout() {
        return R.layout.activity_banner;
    }

    @Override
    public boolean setFullScreem() {
        return true;
    }

    @Override
    protected void doBusiness() {

    }

    @Override
    protected void initActions() {

    }

    @Override
    protected void initWidgets() {
        Intent intent = getIntent();
        mBanner = (BannerBean) intent.getSerializableExtra("banenr");

        Glide.with(this).load(mBanner.getImagePath()).into(mImage);
        mTitle.setText(mBanner.getTitle());
        mAuthor.setText(mBanner.getAuthor());
        mDetail.setText(mBanner.getDetail());
    }
}
