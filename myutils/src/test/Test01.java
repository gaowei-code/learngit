package test;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/27 18:23
 */
public class Test01 {

    public static void main(String[] args) {
        double d1 = 0.0;
        for (int i = 0; i < 11; i++) {
            d1 += 0.1;
        }
        double d2 = 0.1 * 11;
        System.out.println(d1 + ",,," + d2);
        System.out.println(d1 == d2);
    }
}
