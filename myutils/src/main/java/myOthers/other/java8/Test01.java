package myOthers.other.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/30 15:06
 */
public class Test01 {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(BigDecimal.valueOf(1),"red"));
        apples.add(new Apple(BigDecimal.valueOf(2),"red"));
        apples.add(new Apple(BigDecimal.valueOf(1.5), "green"));
        Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o2.getWeight().compareTo(o1.getWeight());
            }
        });
        System.out.println(apples);
    }
}
