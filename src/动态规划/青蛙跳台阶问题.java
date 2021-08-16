package 动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WJL
 * @date: 2021/08/10 08:57
 **/

public class 青蛙跳台阶问题 {

    public static void main(String[] args) {
        int i = fib(100);

        System.out.println(i);
    }


    //尾递归
    public static int fib(int n) {
        return fib(n, 1, 2);
    }

    public static int fib(int n, int first, int second) {
        if (n < 2) return n == 0 ? 1 : first;
        return fib(n - 1, second % 1000000007, (first + second) % 1000000007);
    }


    //记忆化递归（数组）
    public static int numWays3(int n) {
        return recur(n, new int[1000]);
    }

    public static int recur(int n, int[] arr) {
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        if (arr[n] != 0) return arr[n];

        int v1 = recur(n - 1, arr) % 1000000007;

        int v2 = recur(n - 2, arr) % 1000000007;

        res = (v1 + v2) % 1000000007;

        arr[n] = res;

        return res;
    }


    //记忆化递归（hashmap法）
    static int res;

    public static int numWays2(int n) {
        return recur(n, new HashMap<Integer, Integer>());
    }

    public static int recur(int n, HashMap<Integer, Integer> map) {

        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (map.containsKey(n)) return map.get(n);

        int v1 = recur(n - 1, map) % 1000000007;

        int v2 = recur(n - 2, map) % 1000000007;

        res = (v1 + v2) % 1000000007;

        map.put(n, res);

        return res;
    }


    //这道题和斐波那契一样 只不过初始参数不同
    public static int numWays(int n) {

        int a = 1, b = 1, sum;

        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


}