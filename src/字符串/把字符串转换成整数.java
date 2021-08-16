package 字符串;

/**
 * @author WJL
 * @date: 2021/08/07 12:09
 *
 *把字符串转换成整数
 **/

public class 把字符串转换成整数 {

    public static void main(String[] args) {
        String s = "   +0 123";
        int i = strToInt(s);
        System.out.println(i);
    }

    public static int strToInt(String str) {

        char[] chars = str.trim().toCharArray();

        if (chars.length == 0) return 0;
        int res = 0, band = Integer.MAX_VALUE / 10, j = 1, flag = 1;

        if (chars[0] == '-') {
            flag = -1;
        } else if (chars[0] != '+') {
            j = 0;
        }

        for (int i = j; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') break;
            if (res > band || res == band && chars[i] > '7') return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (chars[i] - '0');
        }

        return res * flag;
    }
}