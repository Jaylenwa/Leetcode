package 数组;

import java.util.HashMap;

/**
 * @author WJL
 * @date: 2021/08/06 14:01
 *
 * 数组中重复的数字
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 **/

public class 数组中重复的数字 {


    public static int findRepeatNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return -1;
    }
}