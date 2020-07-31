package encry;

import string.StringUtil;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/31 14:35
 * base64加密、解密工具类
 */
public class Base64Util {

    private Base64Util(){}

    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * base64加密字符串
     * @param value 待加密字符串
     * @param charSet 编码格式
     * @return 加密后的字符串
     */
    public static String encode(String value, String charSet){
        if (!StringUtil.isEmpty(value)){
            try {
                return new String(Base64.getEncoder().encode(value.getBytes(charSet)), charSet);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * base64解密字符串
     * @param value 待解密的字符串
     * @param charset 编码格式
     * @return 解密后的字符串（原始字符串）
     */
    public static String decode(String value, String charset){
        if (!StringUtil.isEmpty(value)){
            try {
                return new String(Base64.getDecoder().decode(value.getBytes(charset)),charset);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(encode("revbjkeqgrfueqbvclqejgf", "utf-8"));
        System.out.println(decode("cmV2YmprZXFncmZ1ZXFidmNscWVqZ2Y=", "utf-8"));
    }
}
