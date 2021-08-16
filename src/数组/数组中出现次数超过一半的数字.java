package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WJL
 * @date: 2021/08/02 18:20
 * <p>
 * 数组中出现次数超过一半的数字
 **/

public class 数组中出现次数超过一半的数字 {

    public static void main(String[] args) {

        int i = majorityElement(new int[]{1});

        System.out.println(i);
    }


    public static int majorityElement(int[] nums) {

        //[1, 2, 3, 2, 2, 2, 5, 4, 2]
        if (nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length / 2)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    //数组排序法
    public static int majorityElement2(int[] nums) {

        Arrays.sort(nums);

        return nums[nums.length/2];
    }
}