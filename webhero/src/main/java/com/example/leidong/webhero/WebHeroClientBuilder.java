package com.example.leidong.webhero;

import android.content.Context;

import com.example.leidong.webhero.callback.IError;
import com.example.leidong.webhero.callback.IFailure;
import com.example.leidong.webhero.callback.IRequest;
import com.example.leidong.webhero.callback.ISuccess;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Lei Dong on 2018/7/8.
 */
public class WebHeroClientBuilder {
    private String mUrl = null;
    private static final Map<String, Object> PARAMS = WebHeroCreater.getParams();
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mRequestBody = null;
    private Context mContext = null;
    private File mFile = null;
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;

    public WebHeroClientBuilder() {

    }

    public final WebHeroClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final WebHeroClientBuilder params(Map<String, String> params) {
        //this.mParams = params;
        PARAMS.putAll(params);
        return this;
    }

    public final WebHeroClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final WebHeroClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final WebHeroClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final WebHeroClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final WebHeroClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }

    public final WebHeroClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final WebHeroClientBuilder raw(String raw) {
        this.mRequestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final WebHeroClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final WebHeroClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final WebHeroClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final WebHeroClientBuilder request(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    private Map<String, Object> checkParams() {
        return PARAMS;
    }

    public final WebHeroClient build() {
        return new WebHeroClient(mUrl, PARAMS, mIRequest, mISuccess, mIFailure, mIError, mRequestBody, mContext, mFile, mDownloadDir, mExtension, mName);
    }
}
