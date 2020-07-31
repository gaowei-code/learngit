package myOthers.other.java8;

import java.math.BigDecimal;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/30 15:04
 */
public class Apple {

    private BigDecimal weight;
    private String color;

    public Apple(BigDecimal weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight().compareTo(BigDecimal.valueOf(150)) == 1;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }


}
