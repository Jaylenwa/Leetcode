package Tencent精选;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WJL
 * @date: 2021/08/12 11:35
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 **/

public class Z字形变换 {


    public static void main(String[] args) {

        Integer integer = new Integer(289422222);

        Long l = new Long(integer);
        System.out.println(l);


    }

    public static String convert(String s, int numRows) {

        if (numRows < 2) return s;

        List<StringBuilder> list = new ArrayList<>();

        //s的遍历顺序是list的0 到 list.length - 1循环
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        char[] chars = s.toCharArray();
        int flag = -1;
        int j = 0;
        for (char aChar : chars) {
            list.get(j).append(aChar);
            if (j <= 0 || j >= numRows - 1) flag = -flag;
            j += flag; // 1 2
        }

        StringBuilder str = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            str.append(stringBuilder);
        }
        return str.toString();
    }

    class Solution {
        public String convert(String s, int numRows) {
            if (numRows < 2) return s;
            List<StringBuilder> rows = new ArrayList<StringBuilder>();
            for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
            int i = 0, flag = -1;
            for (char c : s.toCharArray()) {
                rows.get(i).append(c);
                if (i == 0 || i == numRows - 1) flag = -flag;
                i += flag;
            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder row : rows) res.append(row);
            return res.toString();
        }
    }

}