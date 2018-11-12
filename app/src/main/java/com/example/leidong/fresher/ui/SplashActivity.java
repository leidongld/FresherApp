package com.example.leidong.fresher.ui;

import android.content.Intent;
import android.widget.TextView;

import com.example.leidong.fresher.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Lei Dong on 2018/11/10.
 */
public class SplashActivity extends BaseActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();

    @BindView(R.id.go)
    TextView go;

    @Override
    public int setLayout() {
        return R.layout.activity_splash;
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

    }

    @OnClick(R.id.go)
    void onClickGo() {
        Intent intent = new Intent(this, AuthenticateActivity.class);
        startActivity(intent);
        finish();
    }
}
