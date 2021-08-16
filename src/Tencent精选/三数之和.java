package Tencent精选;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WJL
 * @date: 2021/08/12 15:11
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 **/

public class 三数之和 {


    public static void main(String[] args) {
        int[] ints = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        // -4 -1 -1 0 1 2
        threeSum(ints);
        List<List<Integer>> lists = threeSum(ints);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    //解析见https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // -4 -1 -1 0 1 2
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    i++;
                } else if (sum > 0) {
                    j--;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }

}