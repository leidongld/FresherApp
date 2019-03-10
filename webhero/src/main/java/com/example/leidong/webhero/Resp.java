package com.example.leidong.webhero;

/**
 * Created by Lei Dong on 2019/3/10.
 */
public class Resp {
    public static final String RESPCODE_SUCCESS = "1000";
    public static final String RESPCODE_FAIL = "1001";
    public static final String RESPCODE_LACK_PARAM = "9501";

    private String respCode;
    private String respMsg;

    public Resp(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
}
