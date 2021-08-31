package 数组;

/**
 * @author WJL
 * @date: 2021/08/02 19:57
 * <p>
 * 连续子数组的最大和
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 **/

public class 连续子数组的最大和 {

    public static void main(String[] args) {

        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
                          //  -2 1 -2 4  3  5 6

        int i = maxSubArray(arr);
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] + nums[i - 1] > nums[i]){
                nums[i] = nums[i] + nums[i - 1];
                res = Math.max(res,nums[i]);
            }
        }

        return res;

    }
}