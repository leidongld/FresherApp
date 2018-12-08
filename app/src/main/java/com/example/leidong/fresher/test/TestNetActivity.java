package com.example.leidong.fresher.test;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leidong.fresher.R;
import com.example.leidong.fresher.ui.BaseActivity;
import com.example.leidong.webhero.WebHeroClientBuilder;
import com.example.leidong.webhero.callback.IError;
import com.example.leidong.webhero.callback.IFailure;
import com.example.leidong.webhero.callback.ISuccess;

import butterknife.BindView;

/**
 * Created by Lei Dong on 2018/12/2.
 */
public class TestNetActivity extends BaseActivity {
    private static final String TAG = TestNetActivity.class.getSimpleName();

    @BindView(R.id.url)
    EditText inputUrl;

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.result)
    TextView result;

    @Override
    public int setLayout() {
        return R.layout.activity_test_net;
    }

    @Override
    public boolean setFullScreem() {
        return true;
    }

    @Override
    protected void doBusiness() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestNetActivity.this, "点击了按钮", Toast.LENGTH_SHORT).show();
                WebHeroClientBuilder builder = new WebHeroClientBuilder();
                builder.url("/test")
                        .success(new ISuccess() {
                            @Override
                            public void onSuccess(String body) {
                                result.setText(body);
                            }
                        })
                        .failure(new IFailure() {
                            @Override
                            public void onFailure() {

                            }
                        })
                        .error(new IError() {
                            @Override
                            public void onError(int code, String message) {

                            }
                        })
                        .build()
                        .get();

            }
        });
    }

    @Override
    protected void initActions() {

    }

    @Override
    protected void initWidgets() {

    }
}
