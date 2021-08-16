package 位运算;

/**
 * @author WJL
 * @date: 2021/08/10 14:23
 * <p>
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 **/

public class 二进制中1的个数 {


    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {

        int res = 0;
        while (n != 0) {

            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

}