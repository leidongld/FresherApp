package com.example.leidong.fresher.ui;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leidong.fresher.R;

import butterknife.BindView;

/**
 * Created by Lei Dong on 2018/11/10.
 */
public class AuthenticateActivity extends BaseActivity {
    private static final String TAG = AuthenticateActivity.class.getSimpleName();

    @BindView(R.id.username)
    EditText mUsername;

    @BindView(R.id.password1)
    EditText mPassword1;

    @BindView(R.id.password2)
    EditText mPassword2;

    @BindView(R.id.buttonRegister)
    Button buttonRegister;

    @BindView(R.id.buttonLogin)
    Button buttonLogin;

    @Override
    public int setLayout() {
        return R.layout.activity_authenticate;
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

    /**
     * 点击注册按钮
     */
    private void onClickRegister() {
        Toast.makeText(this, "点击注册按钮", Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击登录按钮
     */
    private void onClickLogin() {
        Toast.makeText(this, "点击登录按钮", Toast.LENGTH_SHORT).show();
    }
}
