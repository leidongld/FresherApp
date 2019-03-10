package com.example.leidong.fresher.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.dbbean.Customer;
import com.example.leidong.fresher.dbbean.Merchant;
import com.example.leidong.fresher.utils.AuthenticateUtils;
import com.example.leidong.webhero.WebConstants;
import com.example.leidong.webhero.WebHeroClientBuilder;
import com.example.leidong.webhero.callback.IError;
import com.example.leidong.webhero.callback.IFailure;
import com.example.leidong.webhero.callback.ISuccess;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Lei Dong on 2018/12/22.
 */
public class RegisterActivity extends BaseActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();

    private Context mContext = this;

    @BindView(R.id.et_name)
    EditText mEtName;

    @BindView(R.id.et_username)
    EditText mEtUsername;

    @BindView(R.id.et_password)
    EditText mEtPassword;

    @BindView(R.id.et_confirm)
    EditText mEtConfirm;

    @BindView(R.id.et_mobile)
    EditText mEtMobile;

    @BindView(R.id.et_phone)
    EditText mEtPhone;

    @BindView(R.id.et_address)
    EditText mEtAddress;

    @BindView(R.id.et_email)
    EditText mEtEmail;

    @BindView(R.id.et_detail)
    EditText mEtDetail;

    @BindView(R.id.btn_register)
    Button mBtnRegister;

    @BindView(R.id.rg)
    RadioGroup mRg;

    @BindView(R.id.rb_merchant)
    RadioButton mRbMerchant;

    @BindView(R.id.rb_customer)
    RadioButton mRbCustomer;

    @BindView(R.id.rb_administrator)
    RadioButton mRbAdministrator;

    private int mCheckIndex = 0;
    private static final int CUSTOMER_INDEX = 1;
    private static final int MERCHANT_INDEX = 2;

    @Override
    public int setLayout() {
        return R.layout.activity_register;
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
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_customer) {
                    mCheckIndex = CUSTOMER_INDEX;
                } else if (checkedId == R.id.rb_merchant) {
                    mCheckIndex = MERCHANT_INDEX;
                } else {
                    mCheckIndex = 0;
                }
            }
        });
    }

    @OnClick(R.id.btn_register)
    public void onClickRegisterBtn() {
        String name = mEtName.getText().toString();
        String username = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();
        String confirm = mEtConfirm.getText().toString();
        String phone = mEtPhone.getText().toString();
        String mobile = mEtMobile.getText().toString();
        String email = mEtEmail.getText().toString();
        String address = mEtAddress.getText().toString();
        String detail = mEtDetail.getText().toString();

        if (TextUtils.isEmpty(name)
                || TextUtils.isEmpty(username)
                || TextUtils.isEmpty(password)
                || TextUtils.isEmpty(confirm)
                || TextUtils.isEmpty(phone)
                || TextUtils.isEmpty(mobile)
                || TextUtils.isEmpty(email)
                || TextUtils.isEmpty(address)
                || TextUtils.isEmpty(detail)) {
            Toast.makeText(this, "请将信息填写完整", Toast.LENGTH_SHORT).show();
        }

        if (AuthenticateUtils.registerInputLegal(username, password, confirm)
                && mCheckIndex != 0) {
            if (mCheckIndex == CUSTOMER_INDEX) {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setUsername(username);
                customer.setPassword(password);
                customer.setPhone(phone);
                customer.setMobile(mobile);
                customer.setEmail(email);
                customer.setAddress(address);
                customer.setDetail(detail);
                customerRegister(customer);
            } else if (mCheckIndex == MERCHANT_INDEX) {
                Merchant merchant = new Merchant();
                merchant.setName(name);
                merchant.setUsername(username);
                merchant.setPassword(password);
                merchant.setPhone(phone);
                merchant.setMobile(mobile);
                merchant.setEmail(email);
                merchant.setAddress(address);
                merchant.setDetail(detail);
                merchantRegister(merchant);
            }
        } else {
            Toast.makeText(this, "你的输入不合法，请保证两次输入的密码长度一致", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 卖家注册
     *
     * @param merchant
     */
    private void merchantRegister(final Merchant merchant) {
        WebHeroClientBuilder builder = new WebHeroClientBuilder();

        // 发起网络请求
        builder.url(WebConstants.BASE_URL + "merchant/registerMerchant")
                .params("merchant", merchant)
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.d(TAG, "注册卖家请求失败！");
                        Toast.makeText(RegisterActivity.this, "注册卖家请求失败", Toast.LENGTH_SHORT).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String message) {
                        Log.e(TAG, "注册卖家请求错误！");
                        Toast.makeText(RegisterActivity.this, "注册卖家请求错误！\n[respCode] " + code + "\n[respMsg] " + message, Toast.LENGTH_SHORT).show();
                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String body) {
                        Log.d(TAG, "注册卖家请求成功");
                        // TODO: 2018/12/30 判断body中的返回码
                        Toast.makeText(RegisterActivity.this, "注册卖家请求成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, RegisterActivity.class);
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
     * @param customer
     */
    private void customerRegister(final Customer customer) {
        WebHeroClientBuilder builder = new WebHeroClientBuilder();

        // 发起网络请求
        builder.url(WebConstants.BASE_URL + "customer/registerCustomer")
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
}
