package encry;

import sun.applet.Main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/31 18:02
 * md5工具类
 */
public class Md5Util {

    private Md5Util(){}

    /**
     * MD5加密
     * @param value 待加密字符串
     * @return 加密后的字符串
     */
    public static String getMD5(String value){
        String md5Str = "";
        try {
            // 创建MD5算法消息摘要
            MessageDigest digest = MessageDigest.getInstance("MD5");
            // 生成的hash值的字节数组
            byte[] md5Bytes = digest.digest(value.getBytes());
            md5Str = bytes2Hex(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Str;
    }

    /**
     * 2进制转16进制
     */
    private static String bytes2Hex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        int temp;
        try {
            for (int i = 0; i < bytes.length; i++) {
                temp = bytes[i];
                if(temp < 0) {
                    temp += 256;
                }
                if (temp < 16) {
                    result.append("0");
                }
                result.append(Integer.toHexString(temp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getMD5("123456"));
    }
}
