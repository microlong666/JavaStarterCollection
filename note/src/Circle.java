/**
 * @author MicroLOONG
 */

public class Circle {

    public static void main(String[] args) {
        double area = area(2);
        System.out.println("半径为2的圆面积是：" + area);
    }

    /**
     * 计算圆面积
     * @param r 半径
     * @return 面积
     */
    public static double area(double r) {
        return 3.14 * r * r;
    }
}
