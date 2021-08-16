package 动态规划;

import javax.print.DocFlavor;

/**
 * @author WJL
 * @date: 2021/08/03 12:32
 * <p>
 * 求数组中不相邻数的最大值
 **/

public class Test1 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 4, 1, 7, 8, 3};

        int i = rec_opt2(arr);
        System.out.println(i);
    }


    public static int rec_opt(int[] arr, int i) {

        if (i == 0) return arr[0];
        if (i == 1) return Math.max(arr[0], arr[1]);

        int A = rec_opt(arr, i - 2) + arr[i];
        int B = rec_opt(arr, i - 1);

        return Math.max(A, B);
    }


    public static int rec_opt2(int[] arr) {

        int[] res = new int[arr.length];

        res[0] = arr[0];
        res[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int A = res[i - 2] + arr[i];
            int B = res[i - 1];
            res[i] = Math.max(A,B);
        }
        return res[arr.length - 1];
    }
}