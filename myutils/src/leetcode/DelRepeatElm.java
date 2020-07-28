package leetcode;

import java.util.Arrays;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/28 11:42
 * 删除排序数组的重复项
 */
public class DelRepeatElm {

    public static int delRepeatElm(int[] arr){
        if (arr.length == 0){
            return 0;
        }
        int result = 0;
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            int num1 = arr[temp];
            int num2 = arr[i];
            if (num1 != num2){
                arr[result] = num1;
                arr[result+1] = num2;
                temp = i;
                result ++;
            }
        }
        return result+1;

    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,1,1,1,1,1,3,3,3,4,5,6};
        System.out.println(delRepeatElm(arr));
        System.out.println(Arrays.toString(arr));
    }
}
