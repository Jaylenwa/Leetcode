package Tencent精选;

/**
 * @author WJL
 * @date: 2021/08/12 10:54
 **/

public class 字符串转换整数 {

    //4193 with words


    public static void main(String[] args) {
        String s = "  +0123";
        int i = myAtoi(s);
        System.out.println(i);
    }

    public static int myAtoi(String s) {
        char[] chars = s.trim().toCharArray();

        if (chars.length == 0) return 0;
        int flag = 1;
        int index = 0;
        int sum = 0;

        if (chars[0] == '-') {
            index = 1;
            flag = -1;
        } else if (chars[0] == '+') {
            index = 1;
            flag = 1;
        }

        int old;
        for (int i = index; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                int res = chars[i] - '0';
                old = sum;
                sum = sum * 10 + res;
                if (old != sum / 10 && flag > 0){
                    return Integer.MAX_VALUE;
                }else if (old != sum / 10 && flag < 0){
                    return Integer.MIN_VALUE * flag;
                }
            } else {
                break;
            }
        }
        return sum * flag;
    }
}