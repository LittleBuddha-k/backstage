package com.littlebuddha.backstage.common.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * MD5加密
 * @author ck
 * @date 2020/7/17 10:29
 */
public class MD5Encryption {

    public static String getEncryptionPassword(String password,String salt){
        Md5Hash md5Hash = new Md5Hash(password,salt,1024);
        String encryptionPassword = md5Hash.toHex();
        return encryptionPassword;
    }

}
