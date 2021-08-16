package 字符串;

import java.util.ArrayList;

/**
 * @author WJL
 * @date: 2021/08/07 14:00
 * <p>
 * <p>
 * 滑动窗口的最大值
 **/

public class 滑动窗口的最大值 {

    private int[] temp;



    public static void main(String[] args) {

        滑动窗口的最大值 question59_i = new 滑动窗口的最大值();

        int[] ints = question59_i.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {

            System.out.println(anInt);
        }

    }



    public int[] maxSlidingWindow(int[] nums, int k) {


        if(k == 1) return nums;

        if (nums == null || nums.length == 0) return nums;
        temp = new int[k];
        int right = k - 1;

        ArrayList<Integer> arr = new ArrayList<>();

        int left = 0;
        while (right < nums.length) {
            int index = 0;
            for (int i = left; i < k + left; i++) {
                temp[index++] = nums[i];
            }
            int max = findMax(temp);
            arr.add(max);
            left++;
            right++;
        }

        int i = 0;
        int[] res = new int[arr.size()];
        for (Integer integer : arr) {
            res[i++] = integer;
        }
        return res;
    }

    //找数组中的最大值

    public  int findMax(int[] arr) {
//        if (arr.length == 0) return 0;
//        if (arr.length == 1) return arr[0];
//        if (arr.length == 2) return Math.max(arr[0],arr[1]);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                arr[i] = arr[i] + arr[i + 1];
                arr[i + 1] = arr[i] - arr[i + 1];
                arr[i] = arr[i] = arr[i + 1];
            }
        }
        return arr[arr.length - 1];
    }
}