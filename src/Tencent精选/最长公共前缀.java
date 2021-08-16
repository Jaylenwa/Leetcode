package Tencent精选;

/**
 * @author WJL
 * @date: 2021/08/12 14:56
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 **/

public class 最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) break;
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) return ans;
        }
        return ans;
    }

}