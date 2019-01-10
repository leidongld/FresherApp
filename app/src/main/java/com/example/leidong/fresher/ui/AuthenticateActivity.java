package com.example.leidong.fresher.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.dbbean.Administrator;
import com.example.leidong.fresher.dbbean.Customer;
import com.example.leidong.fresher.dbbean.Merchant;
import com.example.leidong.fresher.utils.AuthenticateUtils;
import com.example.leidong.webhero.WebConstants;
import com.example.leidong.webhero.WebHeroClientBuilder;
import com.example.leidong.webhero.callback.IError;
import com.example.leidong.webhero.callback.IFailure;
import com.example.leidong.webhero.callback.ISuccess;

import java.util.UUID;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Lei Dong on 2018/11/10.
 */
public class AuthenticateActivity extends BaseActivity {
    private static final String TAG = AuthenticateActivity.class.getSimpleName();
    private Context mContext = this;

    private static final int CUSTOMER_INDEX = 1;
    private static final int MERCHANT_INDEX = 2;

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
                    mCheckIndex = CUSTOMER_INDEX;
                } else if (checkedId == R.id.radioButtonSeller) {
                    mCheckIndex = MERCHANT_INDEX;
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
            if (mCheckIndex == CUSTOMER_INDEX) {
                customerRegister(username, password1);
            } else if (mCheckIndex == MERCHANT_INDEX) {
                merchantRegister(username, password1);
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
     * 卖家注册
     *
     * @param username
     * @param password
     */
    private void merchantRegister(String username, String password) {
        WebHeroClientBuilder builder = new WebHeroClientBuilder();

        // 填充数据
        final Merchant merchant = new Merchant();
        merchant.setId(UUID.randomUUID().toString());
        merchant.setUsername(username);
        merchant.setPassword(password);

        // 发起网络请求
        builder.url(WebConstants.BASE_URL + "/registerMerchant")
                .params("merchant", merchant)
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.d(TAG, "注册卖家请求失败！");
                        Toast.makeText(AuthenticateActivity.this, "注册卖家请求失败", Toast.LENGTH_SHORT).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String message) {
                        Log.e(TAG, "注册卖家请求错误！");
                        Toast.makeText(AuthenticateActivity.this, "注册卖家请求错误！\n[respCode] " + code + "\n[respMsg] " + message, Toast.LENGTH_SHORT).show();
                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        Log.d(TAG, "注册卖家请求成功");
                        // TODO: 2018/12/30 判断body中的返回码 
                        Toast.makeText(AuthenticateActivity.this, "注册卖家请求成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AuthenticateActivity.this, AuthenticateDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("merchant", merchant);
                        mContext.startActivity(intent, bundle);
                    }
                })
                .build()
                .post();
    }

    /**
     * 买家注册
     *
     * @param username
     * @param password
     */
    private void customerRegister(String username, String password) {
        WebHeroClientBuilder builder = new WebHeroClientBuilder();

        // 填充数据
        final Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setUsername(username);
        customer.setPassword(password);

        // 发起网络请求
        builder.url(WebConstants.BASE_URL + "/registerCustomer")
                .params("customer", customer)
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.d(TAG, "注册买家请求失败！");
                        Toast.makeText(mContext, "注册买家请求失败！", Toast.LENGTH_SHORT).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String message) {
                        Log.e(TAG, "注册买家请求错误！");
                        Toast.makeText(mContext, "注册买家请求错误！\\n[respCode] \" + code + \"\\n[respMsg] \" + message", Toast.LENGTH_SHORT).show();
                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        Log.d(TAG, "注册买家请求成功");
                        // TODO: 2018/12/30 判断body中的返回码 
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("customer", customer);
                        mContext.startActivity(intent, bundle);
                    }
                })
                .build()
                .post();
    }

    /**
     * 管理员登录
     *
     * @param username
     * @param password1
     */
    private void adminLogin(String username, String password1) {
        WebHeroClientBuilder builder = new WebHeroClientBuilder();

        // 填充数据
        Administrator administrator = new Administrator();
        administrator.setUsername(username);
        administrator.setPassword(password1);

        // 发起网络请求
        builder.url(WebConstants.BASE_URL + "/adminLogin")
                .params("administrator", administrator)
                .error(new IError() {
                    @Override
                    public void onError(int code, String message) {
                        Toast.makeText(mContext, "管理员登录请求错误！", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "管理员登录请求错误！");
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(mContext, "管理员登录请求失败！", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "管理员登录请求失败！");
                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        Log.d(TAG, "管理员登录请求成功");
                        // TODO: 2018/12/30 判断body中的返回码
                        Intent intent = new Intent(AuthenticateActivity.this, MainActivity.class);
                        // TODO: 2018/12/30 加上id
                        mContext.startActivity(intent);
                        finish();
                    }
                })
                .build()
                .post();
    }

    /**
     * 卖家登录
     *
     * @param username
     * @param password1
     */
    private void merchantLogin(String username, String password1) {
        WebHeroClientBuilder builder = new WebHeroClientBuilder();

        // 填充数据
        Merchant merchant = new Merchant();
        merchant.setUsername(username);
        merchant.setPassword(password1);

        // 发送请求
        builder.url(WebConstants.BASE_URL + "/merchantLogin")
                .params("merchant", merchant)
                .error(new IError() {
                    @Override
                    public void onError(int code, String message) {
                        Log.e(TAG, "卖家登录请求错误!");
                        Toast.makeText(mContext, "卖家登录请求错误！", Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.d(TAG, "卖家登录请求失败！");
                        Toast.makeText(mContext, "卖家登录请求失败！", Toast.LENGTH_SHORT).show();
                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        Log.d(TAG, "卖家登录请求成功！");
                        // TODO: 2018/12/30 判断body中的返回码 
                        Intent intent = new Intent(AuthenticateActivity.this, MainActivity.class);
                        // TODO: 2018/12/30 加上id
                        mContext.startActivity(intent);
                        finish();
                    }
                })
                .build()
                .post();
    }

    /**
     * 买家登录
     *
     * @param username
     * @param password1
     */
    private void customerLogin(String username, String password1) {
        WebHeroClientBuilder builder = new WebHeroClientBuilder();

        // 填充参数
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password1);

        builder.url(WebConstants.BASE_URL + "/customerLogin")
                .params("customer", customer)
                .error(new IError() {
                    @Override
                    public void onError(int code, String message) {
                        Log.e(TAG, "买家登录请求错误！");
                        Toast.makeText(mContext, "买家登录请求错误！", Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.d(TAG, "买家登录请求失败!");
                        Toast.makeText(mContext, "买家登录请求失败!", Toast.LENGTH_SHORT).show();
                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        Log.d(TAG, "买家登录请求成功！");
                        // TODO: 2018/12/30 判断body中的返回码
                        Intent intent = new Intent(AuthenticateActivity.this, MainActivity.class);
                        // TODO: 2018/12/30 增加id
                        mContext.startActivity(intent);
                        finish();
                    }
                })
                .build()
                .post();
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
            if (mCheckIndex == CUSTOMER_INDEX) {
                customerLogin(username, password1);
            } else if (mCheckIndex == MERCHANT_INDEX) {
                merchantLogin(username, password1);
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
