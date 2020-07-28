package test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/28 9:48
 */
public class Test02 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        System.out.println(list.size());

        long start = System.currentTimeMillis()/1000;
        for (int i = 0; i < list.size(); i++) {
            int elm = list.get(i);
            System.out.println(elm);
        }
        long end = System.currentTimeMillis()/1000;
        long time1 = end - start;

        start = System.currentTimeMillis()/1000;
        for (Integer integer : list) {
            int elm = integer;
            System.out.println(elm);
        }
        end = System.currentTimeMillis()/1000;
        long time2 = end - start;

        start = System.currentTimeMillis()/1000;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            int elm = it.next();
            System.out.println(elm);
        }
        end = System.currentTimeMillis()/1000;
        long time3 = end - start;
        System.out.println("for循环时间为："+time1);
        System.out.println("增强for循环时间为："+time2);
        System.out.println("迭代器循环时间为："+time3);
    }
}
