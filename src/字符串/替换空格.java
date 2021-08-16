package 字符串;

/**
 * @author WJL
 * @date: 2021/08/06 14:33
 * 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 **/

public class 替换空格 {

    public static void main(String[] args) {
        String s = "We are happy";
        String s1 = replaceSpace1(s);
        System.out.println(s1);
    }

    //神仙方法
    public static String replaceSpace1(String s) {
        return s.replace(" ","%20");
    }


    //智障方法
    public static String replaceSpace(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}