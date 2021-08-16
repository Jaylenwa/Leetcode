package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WJL
 * @date: 2021/08/06 11:15
 *
 *  排序数组中只出现一次的数字
 *
 *  给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 *
 **/

public class 排序数组中只出现一次的数字 {

    public static void main(String[] args) {

        int[] arr = {1,1, 3, 3,4};
        int i = singleNonDuplicate1(arr);
        System.out.println(i);
    }

    //使用双指针
    public static int singleNonDuplicate1(int[] nums) {

        if (nums.length == 1) return nums[0];

        int i = 0;
        int j = 1;
        while (nums[i] == nums[j]) {
            if (j < nums.length - 2){
                i = j + 1;
                j = i + 1;
            }else {
                return nums[j + 1];
            }
        }
        return nums[i];


    }

    //使用hash表
    public static int singleNonDuplicate(int[] nums) {

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                res = m.getKey();
                break;
            }
        }
        return res;
    }
}