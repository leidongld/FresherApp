package com.example.leidong.fresher.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.leidong.fresher.R;
import com.example.leidong.securitybox.rsa.RSABox;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/11/18.
 */
public class RSATestActivity extends AppCompatActivity {
    @BindView(R.id.input)
    EditText input;

    @BindView(R.id.button1)
    Button button1;

    @BindView(R.id.privateKey)
    TextView privateKey;

    @BindView(R.id.publicKey)
    TextView publicKey;

    @BindView(R.id.enStr1)
    TextView enStr1;

    @BindView(R.id.deStr1)
    TextView deStr1;

    @BindView(R.id.button2)
    Button button2;

    @BindView(R.id.enStr2)
    TextView enStr2;

    @BindView(R.id.deStr2)
    TextView deStr2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsa);
        ButterKnife.bind(this);

        try {
            privateKey.setText(RSABox.generateKeyPair().get(RSABox.PRIVATE_KEY));
            publicKey.setText(RSABox.generateKeyPair().get(RSABox.PUBLIC_KEY));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 私钥加密公钥解密
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 公钥加密私钥解密
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
