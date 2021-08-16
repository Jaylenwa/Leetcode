package 数组;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author WJL
 * @date: 2021/08/02 15:16
 * 调整数组顺序使奇数位于偶数前面
 **/

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {

        int[] exchange = exchange2(new int[]{1, 2, 3, 4});

        for (int i : exchange) {
            System.out.println(i);
        }

    }

    //双指针写法
    public static int[] exchange(int[] nums) {

        int head = 0, tail = nums.length - 1;

        int temp;

        while (head < tail) {

            if ((nums[head] & 1) == 1) {
                head++;
                continue;
            }

            if ((nums[tail] & 1) == 0) {
                tail--;
                continue;
            }

            nums[head] = nums[head] ^ nums[tail];
            nums[tail] = nums[head] ^ nums[tail];
            nums[head] = nums[head] ^ nums[tail];

        }

        return nums;
    }


    //快慢针写法
    public static int[] exchange2(int[] nums) {

        int fast = 0, slow = 0;
        int temp;

        while (fast < nums.length) {

            if ((nums[fast] & 1) == 1){
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++;

        }

        return nums;
    }



}
