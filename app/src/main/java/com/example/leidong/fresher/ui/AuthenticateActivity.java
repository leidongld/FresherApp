package com.example.leidong.fresher.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.utils.AuthenticateUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Lei Dong on 2018/11/10.
 */
public class AuthenticateActivity extends BaseActivity {
    private static final String TAG = AuthenticateActivity.class.getSimpleName();

    private static final int ADMIN_INDEX = -100;
    private static final int BUYER_INDEX = 1;
    private static final int SELLER_INDEX = 2;

    @BindView(R.id.username)
    EditText mUsername;

    @BindView(R.id.password1)
    EditText mPassword1;

    @BindView(R.id.password2)
    EditText mPassword2;

    @BindView(R.id.radioGroup)
    RadioGroup mRadioGroup;

    @BindView(R.id.radioButtonBuyer)
    RadioButton mRadioButtonBuyer;

    @BindView(R.id.radioButtonSeller)
    RadioButton mRadioButtonSeller;

    @BindView(R.id.buttonRegister)
    Button buttonRegister;

    @BindView(R.id.buttonLogin)
    Button buttonLogin;

    private int mCheckIndex = 0;

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
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonBuyer) {
                    mCheckIndex = BUYER_INDEX;
                } else if (checkedId == R.id.radioButtonSeller) {
                    mCheckIndex = SELLER_INDEX;
                } else {
                    mCheckIndex = 0;
                }
            }
        });
    }

    /**
     * 点击注册按钮
     */
    @OnClick(R.id.buttonRegister)
    void onClickRegister() {
        String username = mUsername.getText().toString().trim();
        String password1 = mPassword1.getText().toString().trim();
        String password2 = mPassword2.getText().toString().trim();

        if (AuthenticateUtils.registerInputLegal(username, password1, password2)
                && mCheckIndex != 0) {
            if (mCheckIndex == BUYER_INDEX) {
                buyerRegister(username, password1);
            } else if (mCheckIndex == SELLER_INDEX) {
                sellerRegister(username, password1);
            } else {
                adminRegister(username, password1);
            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("警告");
            builder.setMessage("您的输入不合法。请保证输入不为空且密码长度大于8位");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mUsername.setText(null);
                    mPassword1.setText(null);
                    mPassword2.setText(null);
                }
            });
            builder.setNegativeButton("取消", null);
            builder.create().show();
        }
    }

    /**
     * 管理员注册
     *
     * @param username
     * @param password1
     */
    private void adminRegister(String username, String password1) {

    }

    /**
     * 卖家注册
     *
     * @param username
     * @param password1
     */
    private void sellerRegister(String username, String password1) {

    }

    /**
     * 买家注册
     *
     * @param username
     * @param password1
     */
    private void buyerRegister(String username, String password1) {
    }

    /**
     * 管理员登录
     *
     * @param username
     * @param password1
     */
    private void adminLogin(String username, String password1) {
    }

    /**
     * 卖家登录
     *
     * @param username
     * @param password1
     */
    private void sellerLogin(String username, String password1) {
    }

    /**
     * 买家登录
     *
     * @param username
     * @param password1
     */
    private void buyerLogin(String username, String password1) {
    }

    /**
     * 点击登录按钮
     */
    @OnClick(R.id.buttonLogin)
    void onClickLogin() {
        String username = mUsername.getText().toString().trim();
        String password1 = mPassword1.getText().toString().trim();

        if (AuthenticateUtils.loginInputLegal(username, password1)
                && mCheckIndex != 0) {
            if(mCheckIndex == BUYER_INDEX) {
                buyerLogin(username, password1);
            } else if(mCheckIndex == SELLER_INDEX) {
                sellerLogin(username, password1);
            } else {
                adminLogin(username, password1);
            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("警告");
            builder.setMessage("您的输入不合法。请保证输入不为空且密码长度大于8位，两次输入的密码必须一致");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mUsername.setText(null);
                    mPassword1.setText(null);
                    mPassword2.setText(null);
                }
            });
            builder.setNegativeButton("取消", null);
            builder.create().show();
        }
    }
}
