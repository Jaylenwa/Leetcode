package Tencent精选;

import javax.print.DocFlavor;
import java.util.function.IntFunction;

/**
 * @author WJL
 * @date: 2021/08/12 10:22
 **/

public class 整数反转 {

    public static void main(String[] args) {
        int reverse = reverse(15342369); //max21亿
        System.out.println(reverse);
    }

    public static int reverse(int x) {

        int tep = 0;
        int last;

        while (x != 0) {
            last = tep;
            tep = tep * 10 + x % 10;
            if (last != tep /10){
                return 0;
            }
            x = x / 10;
        }

        return tep;
    }
}