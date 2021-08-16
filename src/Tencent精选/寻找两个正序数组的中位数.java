package Tencent精选;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author WJL
 * @date: 2021/08/12 09:33
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 **/

public class 寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{3, 4, 5};
        double medianSortedArrays = findMedianSortedArrays2(a, b);
        System.out.println(medianSortedArrays);
    }


    //大顶堆 小顶堆写
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int i : nums1) {
            if (maxHeap.size() != minHeap.size()) {
                minHeap.offer(i);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(i);
                minHeap.offer(maxHeap.poll());
            }
        }

        for (int i : nums2) {
            if (maxHeap.size() != minHeap.size()) {
                minHeap.offer(i);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(i);
                minHeap.offer(maxHeap.poll());
            }
        }

        int size = maxHeap.size() + minHeap.size();
        return (size & 1) == 0 ? (maxHeap.peek() + minHeap.peek()) / 2.0 : minHeap.peek();

    }


    //排序再求中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length = nums1.length + nums2.length;
        int[] res = new int[length];

        int index = 0;

        for (int j : nums1) {
            res[index++] = j;
        }

        for (int j : nums2) {
            res[index++] = j;
        }

        Arrays.sort(res);

        // 1 2 3 4
        if ((length & 1) == 1) {
            return res[length / 2];
        }

        if ((length & 1) == 0) {
            return (res[length / 2] + res[length / 2 - 1]) / 2.0;
        }

        return 0.0;

    }
}