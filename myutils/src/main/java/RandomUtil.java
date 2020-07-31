import java.util.Random;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/31 16:26
 * 随机数工具类
 */
public class RandomUtil {

    private RandomUtil(){}

    private static final Random RANDOM = new Random();

    /**
     * 获取从0 到 maxvalue之间的一个随机数
     * @param maxValue 最大值
     * @return 随机值
     */
    public static int getRandom(int maxValue){
        return RANDOM.nextInt(maxValue+1);
    }

    /**
     * 获取从minValue到maxValue之间的一个随机值
     * @param minValue 最小值
     * @param maxValue 最大值
     * @return 随机值
     */
    public static int getRandom(int minValue, int maxValue){
        if (maxValue >= minValue){
            return RANDOM.nextInt(maxValue - minValue + 1) +minValue;
        }
        return 0;
    }

    /**
     * 获取随机验证码
     * @param len 验证码长度
     * @return 验证码
     */
    public static String getRandomNumStr(int len){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(getRandom(9));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getRandom(1));
        System.out.println(getRandomNumStr(4));
    }
}
