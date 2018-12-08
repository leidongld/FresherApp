package com.example.leidong.webhero;

import android.content.Context;

import com.example.leidong.webhero.callback.IError;
import com.example.leidong.webhero.callback.IFailure;
import com.example.leidong.webhero.callback.IRequest;
import com.example.leidong.webhero.callback.ISuccess;
import com.example.leidong.webhero.callback.RequestCallbacks;

import java.io.File;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Lei Dong on 2018/7/8.
 */
public class WebHeroClient {
    private final String URL;
    private final Map<String, Object> PARAMS = WebHeroCreater.getParams();

    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private final File FILE;
    private final Context CONTEXT;


    public WebHeroClient(
            String url,
            Map<String, Object> params,
            IRequest request,
            ISuccess success,
            IFailure failure,
            IError error,
            RequestBody body,
            Context context,
            File file,
            String downloadDir,
            String extension,
            String name) {
        this.URL = url;
        this.PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.CONTEXT = context;
        this.FILE = file;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
    }

    public static WebHeroClientBuilder builder() {
        return new WebHeroClientBuilder();
    }

    private void request(HttpMethods method) {
        final WebHeroService webHeroService = WebHeroCreater.getRestService();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        switch (method) {
            case GET:
                call = webHeroService.get(URL, PARAMS);
                break;
            case POST:
                call = webHeroService.post(URL, PARAMS);
                break;
            case POSTRAM:
                call = webHeroService.postRaw(URL, BODY);
                break;
            case PUT:
                call = webHeroService.put(URL, PARAMS);
                break;
            case PUTRAM:
                call = webHeroService.putRaw(URL, BODY);
                break;
            case DELETE:
                call = webHeroService.delete(URL, PARAMS);
                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallbacks(REQUEST, SUCCESS, FAILURE, ERROR);
    }

    public final void get() {
        request(HttpMethods.GET);
    }

    public final void post() {
        if (BODY == null) {
            request(HttpMethods.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("Params must be null.");
            }
            request(HttpMethods.POSTRAM);
        }
    }

    public final void put() {
        if (BODY == null) {
            request(HttpMethods.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("Params must be null.");
            }
            request(HttpMethods.PUTRAM);
        }
    }

    public final void delete() {
        request(HttpMethods.DELETE);
    }

}
