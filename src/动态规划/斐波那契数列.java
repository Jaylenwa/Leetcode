package 动态规划;

import java.util.ArrayList;

/**
 * @author WJL
 * @date: 2021/08/09 17:04
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 **/

public class 斐波那契数列 {

    public static void main(String[] args) {

        // 0 1 1 2 3 5 8 13
        System.out.println(f(5));
    }


    //动态规划
    public int fib43(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i < 2) {
                dp[i] = i;
                continue;
            }
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    //尾递归
    public static int fib4(int n) {
        return fib(n, 1, 1);
    }

    public static int fib(int n, int first, int second) {
        if (n < 2) return n == 0 ? 0 : first;
        return fib(n - 1, second % 1000000007, (first + second) % 1000000007);
    }



    public static int fib2(int n) {

        int a = 0, b = 1, sum;

        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static int f(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        for (int i = 2; i <= n; i++) {
            arr.add((arr.get(i - 1) + arr.get(i - 2)) % 1000000007);
        }
        return arr.get(n);
    }


    //递归
    public static int fib(int n) {
        return fi(n) % 1000000007;
    }

    public static int fi(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fi(n - 1) + fi(n - 2);
    }

}