package myOthers.other.java8;

import java.util.function.Function;

/**
 * @Description
 * @Author gw
 * @Date 2020/8/3 9:58
 */
public class Test02 {

    public static void main(String[] args) {
        String content = "Hello Java";
        Function<Integer, String> func = content::substring;
        System.out.println(func.apply(0));
    }
}
