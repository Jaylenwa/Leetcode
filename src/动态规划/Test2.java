package 动态规划;

/**
 * @author WJL
 * @date: 2021/08/03 16:31
 *
 * 任意多数之和
 **/

public class Test2 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 34, 4, 12, 5, 2};
        System.out.println(subset(arr, arr.length - 1, 9));
        System.out.println(subset(arr, arr.length - 1, 10));
        System.out.println(subset(arr, arr.length - 1, 11));
        System.out.println(subset(arr, arr.length - 1, 12));
        System.out.println(subset(arr, arr.length - 1, 13   ));
    }

    public static boolean subset(int[] arr, int i, int target) {

        if (i == 0) return arr[0] == target;

        if (target == 0) return true;

        if (arr[i] > target) return subset(arr, i -1, target);

        boolean A = subset(arr, i - 1, target - arr[i]);

        boolean B = subset(arr, i - 1, target);

        return A || B;
    }
}