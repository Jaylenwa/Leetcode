package 字符串;

import java.util.ArrayList;

/**
 * @author WJL
 * @date: 2021/08/07 12:08
 *
 * 翻转单词顺序
 **/

public class 翻转单词顺序 {


    public static String reverseWords(String s) {

        String[] str = s.trim().split("\\s+");  //删除首尾的空格，然后分隔字符串
        StringBuilder sb = new StringBuilder();
        for (int j = str.length - 1; j >= 0; j--) {
            sb.append(str[j] + " ");
        }
        return sb.toString().trim();
    }


    public static String reverseWords2(String s) {
        s = s.trim();

        ArrayList<String> str = new ArrayList<>();

        int index = 0;
        int tep = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.add(s.substring(tep, i));
                tep = i + 1;
            }
            if (i == s.length() - 1) {
                str.add(s.substring(tep, i + 1));
            }
        }


        StringBuilder resStr = new StringBuilder();
        for (int i = str.size() - 1; i >= 0; i--) {

            if (!str.get(i).equals("")) {
                resStr.append(str.get(i));
                resStr.append(" ");
            }
        }

        return resStr.toString().trim();
    }

}