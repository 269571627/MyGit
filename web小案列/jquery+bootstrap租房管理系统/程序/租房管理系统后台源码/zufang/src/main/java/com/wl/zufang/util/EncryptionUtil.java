package com.wl.zufang.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 明文加密
 *
 * @author w.z
 * @date 2019/9/28 9:38
 */
public class EncryptionUtil {

    /**
     * 注册用户时,随机获取盐值
     *
     * @param length
     * @return
     */
    public static String getMd5HashSalt(int length) {
        /**
         * 盐值
         */
        String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuffer stringBuffer = new StringBuffer();
        try {
            // 生成一个产生随机数的实例
            Random random = SecureRandom.getInstanceStrong();
            for (int i = 0; i < length; i++) {
                // 从定义好的字符中选取要求长度的salt
                int number = random.nextInt(string.length());
                stringBuffer.append(string.charAt(number));
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("EncryptionUtil#getMd5HashSalt:" + e.getMessage());
        }
        return stringBuffer.toString();
    }

    public static String md5Hash(String password, String salt) {
        // 密码加盐
        String md5Password = new Md5Hash(password,salt).toString();
        return md5Password;
    }
    
}
