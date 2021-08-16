package Tencent精选;

import java.util.Arrays;

/**
 * @author WJL
 * @date: 2021/08/12 17:16
 **/

// 1 2 3     2 4 5 2 3 4
public class 合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1, p2 = n - 1, tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}