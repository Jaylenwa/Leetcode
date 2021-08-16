package 字符串;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author WJL
 * @date: 2021/08/06 15:10
 * <p>
 * 第一个只出现一次的字符
 **/

public class 第一个只出现一次的字符 {

    public static void main(String[] args) {
        String s = "eetcode";
        char c = firstUniqChar(s);
        System.out.println(c);
    }

    //使用LinkedHashMap<Character, Boolean>
    public static char firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();

        for (char aChar : chars) {
            map.put(aChar, map.containsKey(aChar));
        }

        for (Map.Entry<Character, Boolean> ch : map.entrySet()) {
            if (!ch.getValue()) {
                return ch.getKey();
            }
        }
        return ' ';
    }

}
