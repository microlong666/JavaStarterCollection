/**
 * @author MicroLOONG
 */
public class Varargs {
    public static void main(String[] args) {
        System.out.println("普通数组 1+2+3 = " + sum1(new int[]{1,2,3}));
        // 可变参数，传递任意数量的参数
        System.out.println("无参数 sum = " + sum2());
        System.out.println("可变参数 1 = " + sum2(1));
        System.out.println("可变参数 1+2 = " + sum2(1, 2));
        System.out.println("可变参数 1+2+3 = " + sum2(1, 2, 3));
    }

    /**
     * 普通数组
     * @param arr 数组
     * @return sum
     */
    public static int sum1(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    /**
     * 可变参数用法
     * @param arr 数组
     * @return sum
     */
    public static int sum2(int... arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
