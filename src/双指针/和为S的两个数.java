package 双指针;

/**
 * @author WJL
 * @date: 2021/08/11 17:33
 **/

public class 和为S的两个数 {

    //      10
    //  1 4 5 7 8  17
    public int[] twoSum(int[] nums, int target) {

        if (nums.length == 1) return new int[0];

        int left = 0, right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[right] >= target){
                right--;
                continue;
            }
            if (nums[left] + nums[right] > target){
                right--;
            }else if (nums[left] + nums[right] < target){
                left++;
            }else {
                return new int[]{nums[left],nums[right]};
            }
        }
        return new int[0];
    }
}