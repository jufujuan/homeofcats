package jfj.homeofcars.Utils;

import java.security.MessageDigest;

/**
 * MD5加密
 */
public abstract class MD5Coder {
    public static byte[] encodeMD5(byte[] data)throws Exception{
        //初始化MessageDigest
        MessageDigest md=MessageDigest.getInstance("MD5");
        return md.digest(data);
    }
}
