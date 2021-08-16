package 字符串;

import java.util.function.IntFunction;

/**
 * @author WJL
 * @date: 2021/08/07 12:10
 * 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
 **/

public class 表示数值的字符串 {

    public static void main(String[] args) {
        String s = "-1.E-16";

        boolean number = isNumber(s);
        System.out.println(number);
    }

    public static boolean isNumber(String s) {

        if (s == null || s.length() == 0) return false;

        char[] chars = s.trim().toCharArray();

        boolean isNum = false, isDot = false, ise_or_E = false;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                isNum = true;
            } else if (chars[i] == '.') {
                if (isDot || ise_or_E) {
                    return false;
                }
                isDot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                if (!isNum || ise_or_E) {
                    return false;
                }
                ise_or_E = true;
                isNum = false;
            } else if (chars[i] == '-' || chars[i] == '+') {
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return isNum;
    }



}