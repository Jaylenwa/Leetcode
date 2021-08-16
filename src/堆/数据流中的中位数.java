package 堆;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author WJL
 * @date: 2021/08/09 15:14
 *
 *
 **/

public class 数据流中的中位数 {

    public static void main(String[] args) {

        addNum1(1);
        System.out.println(findMedian1());
    }


    public 数据流中的中位数() {

    }


    //大顶堆 小顶堆写法
    static Queue<Integer> maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
    static Queue<Integer> minHeap = new PriorityQueue<>();
    //左半边(大顶堆）  右半边（小顶堆）
    public static void addNum1(int num) {

        //向小的一边插入数据要先把数据插入到大的一边，然后大的一边弹出最小值，小的一边再插入这个最小值
        //这样才能保证左边的数都小于右边的数
        if (minHeap.size() == maxHeap.size()){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }


    public static double findMedian1() {
        return minHeap.size() != maxHeap.size() ? maxHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }


    //智障写法
    static ArrayList<Integer> list = new ArrayList<>();

    public static void addNum(int num) {
        list.add(num);
    }

    public static double findMedian() {
        Integer[] integers = list.toArray(new Integer[list.size()]);
        int len = integers.length;
        if (len > 0) {
            quickSore(integers, 0, integers.length - 1);
            if ((len & 1) == 1) {
                return integers[len / 2];
            } else {
                double a = integers[len / 2];
                double b = integers[len / 2 - 1];
                return (a + b) / 2;
            }
        } else {
            return 0;
        }
    }

    public static void quickSore(Integer[] arr, int low, int high) {
        if (arr.length == 0) return;
        if (low >= high) return;
        int index = getIndex(arr, low, high);
        quickSore(arr, low, index - 1);
        quickSore(arr, index + 1, high);

    }

    public static int getIndex(Integer[] arr, int low, int high) {
        int temp = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= temp) {
                low++;
            }

            arr[high] = arr[low];
        }

        arr[low] = temp;
        return low;
    }

}