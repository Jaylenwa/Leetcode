package 数组;

import java.util.HashMap;

/**
 * @author WJL
 * @date: 2021/08/06 09:58

 * 统计一个数字在排序数组中出现的次数
 * 在排序数组中查找数字 I
 * 
 * 统计一个数字在排序数组中出现的次数
 **/

public class 数字在排序数组中出现的次数 {


    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,4,5,6,6};
        int search = search(arr, -1);
        System.out.println(search);
    }

    //使用二分
    public static int search(int[] arr, int target) {

        int res = 0;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //向右二分
            if (arr[mid] < target) {
                left = mid + 1;
                continue;
            }
            //向左二分
            if (arr[mid] > target) {
                right = mid - 1;
                continue;
            }

            //中点的值等于target
            if (arr[mid] == target) {
                res++;
                int tep;
                //统计中点以左等于target的个数
                if (mid > 0) {
                    tep = mid - 1;
                    while (arr[tep] == target) {
                        res++;
                        if (tep > 0) {
                            tep--;
                            continue;
                        }
                        break;
                    }
                }
                //统计中点以右等于target的个数
                if (mid < arr.length - 1) {
                    tep = mid + 1;
                    while (arr[tep] == target) {
                        res++;
                        if (tep < arr.length - 1) {
                            tep++;
                            continue;
                        }
                        break;

                    }
                }
                break;
            }
        }
        return res;
    }

    //使用hash表写
    public static int search2(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        if (map.containsKey(target)){
            return map.get(target);
        }
        return 0;
    }

}