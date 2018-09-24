package com.example.leidong.fresher.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;

/**
 * Created by Lei Dong on 2018/9/24.
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 设置布局id
     * @return
     */
    public abstract int setLayout();

    /**
     * 设置
     * @return
     */
    public abstract boolean setFullScreem();

    /**
     * 设置窗口属性
     */
    protected void configActivityWindow() {
        if (setFullScreem()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configActivityWindow();
        setContentView(setLayout());

        ButterKnife.bind(this);

        initWidgets();

        initActions();

        doBusiness();
    }

    /**
     * 业务逻辑
     */
    protected abstract void doBusiness();

    /**
     * 初始化动作
     */
    protected abstract void initActions();

    /**
     * 初始化组件
     */
    protected abstract void initWidgets();


}
