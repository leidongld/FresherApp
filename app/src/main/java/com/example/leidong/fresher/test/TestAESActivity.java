package com.example.leidong.fresher.test;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leidong.fresher.R;
import com.example.leidong.securitybox.aes.AESBox;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/11/18.
 */
public class TestAESActivity extends AppCompatActivity {
    @BindView(R.id.key)
    TextView key;

    @BindView(R.id.inputStr)
    EditText inputStr;

    @BindView(R.id.enStr)
    TextView enStr;

    @BindView(R.id.deStr)
    TextView deStr;

    @BindView(R.id.genKey)
    Button genKeyBtn;

    @BindView(R.id.encrypt)
    Button encryptBtn;

    @BindView(R.id.decrypt)
    Button decryptBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aes);
        ButterKnife.bind(this);

        initWidgets();

        initActicons();

    }

    private void initActicons() {
        genKeyBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                try {
                    key.setText(AESBox.generateKey());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        encryptBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String k = key.getText().toString();
                String input = inputStr.getText().toString();
                try {
                    String res = AESBox.encrypt(k, input);
                    Toast.makeText(TestAESActivity.this, "加密结果" + res, Toast.LENGTH_SHORT).show();
                    enStr.setText(res);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        decryptBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String k = key.getText().toString();
                String input = enStr.getText().toString();
                try {
                    String res = AESBox.decrypt(k, input);
                    deStr.setText(res);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void initWidgets() {

    }
}
