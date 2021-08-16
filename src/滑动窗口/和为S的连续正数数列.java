package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WJL
 * @date: 2021/08/11 16:55
 **/

public class 和为S的连续正数数列 {
    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(3);
        for (int[] ints : continuousSequence) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    //滑动窗口
    public static int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;

        ArrayList<int[]> arr = new ArrayList<>();

        while (i < j) {
            if (s == target) {
                int[] res = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    res[k - i] = k;
                }
                arr.add(res);
            }
            if (s >= target) {
                s = s - i;
                i++;
            } else {
                j++;
                s = s + j;
            }
        }
        return arr.toArray(new int[0][]);
    }
}
