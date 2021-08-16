package 动态规划;

/**
 * @author WJL
 * @date: 2021/08/10 10:56
 **/

public class 机器人的运动范围 {

    //todo

    public static void main(String[] args) {
        int sum = sum(1);
        System.out.println(sum);
    }

    // 123
    public static int sum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}