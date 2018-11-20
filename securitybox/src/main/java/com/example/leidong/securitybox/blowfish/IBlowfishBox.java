package com.example.leidong.securitybox.blowfish;

/**
 * Created by Lei Dong on 2018/11/18.
 */
public interface IBlowfishBox {
    /**
     * 加密
     *
     * @return
     */
    public String encrypt(String inputStr);

    /**
     * 解密
     *
     * @return
     */
    public String decrypt(String inputStr);

    /**
     * 生成密钥
     *
     * @return
     */
    public String createKey();
}
