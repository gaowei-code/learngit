package myOthers.leetcode;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/28 13:43
 * 移除元素
 */
public class RemoveElm {

    public static int removeElem(int[] arr, int value){
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                len ++;
            }
        }
        return arr.length - len;
    }
}
