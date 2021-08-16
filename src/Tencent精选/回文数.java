package Tencent精选;

/**
 * @author WJL
 * @date: 2021/08/12 14:12
 **/

public class 回文数 {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(1);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {

        //1221
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() -1;

        while (i <= j){
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}