package com.example.leidong.fresher.ui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.utils.SPToolkit;
import com.example.leidong.webhero.WebHeroClientBuilder;
import com.example.leidong.webhero.callback.IError;
import com.example.leidong.webhero.callback.IFailure;
import com.example.leidong.webhero.callback.ISuccess;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Lei Dong on 2018/11/10.
 */
public class SplashActivity extends BaseActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();

    private Context mContext;

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
        registerAdmin();
    }

    /**
     * 注册管理员
     */
    private void registerAdmin() {
        boolean isAdminExist = SPToolkit.init(mContext).gainBool("isAdminExist");
        if (!isAdminExist) {
            Map<String, String> params = new HashMap<>();
            params.put("username", "admin");
            params.put("password", "123456");

            WebHeroClientBuilder builder = new WebHeroClientBuilder();
            builder.url("/administrator/createAdministrator")
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String body) {
                            SPToolkit.init(mContext).putBool("isAdminExist", true);
                        }
                    })
                    .failure(new IFailure() {
                        @Override
                        public void onFailure() {
                            Log.d(TAG, "创建管理员失败");
                        }
                    })
                    .error(new IError() {
                        @Override
                        public void onError(int code, String message) {
                            Log.d(TAG, "创建管理员错误");
                        }
                    })
                    .params(params)
                    .build()
                    .post();
        }
    }

    @Override
    protected void initActions() {

    }

    @Override
    protected void initWidgets() {
        mContext = this;
    }

    @OnClick(R.id.go)
    void onClickGo() {
        Intent intent = new Intent(this, AuthenticateActivity.class);
        startActivity(intent);
        finish();
    }
}
