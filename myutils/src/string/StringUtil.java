package string;

import java.util.Date;

/**
 * @Description 字符串相关工具
 * @Author gw
 * @Date 2020/7/27 17:55
 */
public class StringUtil {

    private StringUtil(){}

    /**
     * 判断字符串是否为空
     * @param value 目标字符串
     * @return
     */
    public static boolean isEmpty(String value){
        if (value == null || value.trim().length() == 0){
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否是整型
     * @param value
     * @return
     */
    public static boolean isInt(String value){
        if (isEmpty(value)){
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    /**
     * 判断字符串是否是浮点型
     * @param value
     * @return
     */
    public static boolean isDouble(String value){
        if (isEmpty(value)){
            return false;
        }
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    /**
     * 将字符串转化为整型，若转换不成功，返回0
     * @param value
     * @return
     */
    public static int parseInt(String value){
        int result = 0;
        if (isInt(value)){
            result = Integer.valueOf(value);
        }
        return result;
    }

    /**
     * 将字符串转化为整型，若转换不成功，返回defaultValue
     * @param value
     * @return
     */
    public static int parseInt(String value, int defaultValue){
        int result = defaultValue;
        if (isInt(value)){
            result = Integer.valueOf(value);
        }
        return result;
    }

    /**
     * 将字符串转换为double型，若转换不成功返回 0；
     * @param value
     * @return
     */
    public static double parseDouble(String value){
        double result = 0;
        if (isDouble(value)){
            result = Double.valueOf(value);
        }
        return result;
    }

    /**
     * 将字符串转换为double型，若转换不成功返回 defaultValue；
     * @param value
     * @return
     */
    public static double parseDouble(String value, double defaultValue){
        double result = defaultValue;
        if (isDouble(value)){
            result = Double.valueOf(value);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(parseInt("123www"));
        System.out.println(parseInt("123www",23));
    }

}
