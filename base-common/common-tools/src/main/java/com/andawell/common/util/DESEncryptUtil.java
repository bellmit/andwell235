package com.andawell.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

/**
 * DES工具类
 */
public class DESEncryptUtil {
    private final static String DES = "DES";
    private final static String ENCODE = "UTF-8";
    private final static String defaultKey = "andawell";

    /**
     * 加密
     *
     * @param data 源字符串
     * @return
     * @throws Exception
     */
    public static String encode(String data) throws Exception {
        byte[] bt = encode(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    /**
     * 加密
     *
     * @param data 源字符串
     * @param key  密钥
     * @return
     * @throws Exception
     */
    public static String encode(String data, String key) throws Exception {
        byte[] bt = encode(data.getBytes(ENCODE), key.getBytes(ENCODE));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    private static byte[] encode(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

    /**
     * 解密
     *
     * @param data 源字符串
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decode(String data) throws Exception {
        if (data == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decode(buf, defaultKey.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    /**
     * 解密
     *
     * @param data 源字符串
     * @param key  密钥
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decode(String data, String key) throws Exception {
        if (data == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decode(buf, key.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    private static byte[] decode(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }
}
