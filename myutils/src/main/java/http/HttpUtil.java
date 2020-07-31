package http;

import string.StringUtil;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/31 14:48
 * http工具类
 */
public class HttpUtil {

    private HttpUtil(){}

    /**
     * 判断是不是http请求
     * @param url 请求url
     * @return 是http请求返回true，否则返回false
     */
    public static boolean isHttp(String url){
        if (!StringUtil.isEmpty(url)){
            return url.indexOf("http:") > -1;
        }
        return false;
    }

    /**
     * 判断是不是https请求
     * @param url 请求url
     * @return 是https请求返回true，否则返回false
     */
    public static boolean isHttps(String url){
        if (!StringUtil.isEmpty(url)){
            return url.indexOf("https:") > -1;
        }
        return false;
    }
}
