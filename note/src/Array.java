/**
 * @author MicroLOONG
 */
public class Array {
    public static void main(String[] args) {
        array1();
        array2();
    }

    public static void array1() {
        String[][] s = new String[2][];
        s[0] = new String[2];
        s[1] = new String[3];
        s[0][0] = "Good";
        s[0][1] = "Luck";
        s[1][0] = "to";
        s[1][1] = "you";
        s[1][2] = "!";
        for (String[] row : s) {
            for (String arr : row) {
                System.out.print(arr + " ");
            }
        }
        System.out.println("\n");
    }

    public static void array2() {
        final int max = 5;
        int [][] arr = new int[max + 1][];
        // 分配每一行
        for (int n = 0; n <= max; n++) {
            arr[n] = new int[n + 1];
        }

        //给数组赋值
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int lotteryArr = 1;
                arr[i][j] = lotteryArr;
            }
        }

        //遍历数组
        for (int[] row : arr) {
            for (int a : row) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}

