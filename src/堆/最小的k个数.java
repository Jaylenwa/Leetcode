package 堆;

import java.util.*;

/**
 * @author WJL
 * @date: 2021/08/09 09:07
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 **/

public class 最小的k个数 {



    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] leastNumbers = getLeastNumbers4(arr, 2);
        for (int leastNumber : leastNumbers) {
            System.out.println(leastNumber);
        }

    }

    //直接计数
    public int[] getLeastNumbers5(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num: arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }

    //用BST(二叉搜索树)写
    public static int[] getLeastNumbers4(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // TreeMap的key是数字, value是该数字的个数。
        // cnt表示当前map总共存了多少个数字。
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num : arr) {
            // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);

                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }

        }

        // 最后返回map中的元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }


    //用堆写
    public static int[] getLeastNumbers3(int[] arr, int k) {

        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }


    //快排写
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return arr;

        return quickSort(arr, 0, arr.length - 1, k - 1);

    }

    public static int[] quickSort(int[] arr, int low, int high, int k) {
        if (arr.length == 0) return arr;
        if (low >= high) return arr;
        // 每快排切分1次，找到排序后下标为index的元素，如果index恰好等于k就返回index以及index左边所有的数；
        int index = getIndex(arr, low, high);
        if (index == k) return Arrays.copyOf(arr, index + 1);

        //切记是low不是0 两者性能差距是指数级别的
        //根据下标j与k的大小关系来决定继续切分左段还是右段。
        return index > k ? quickSort(arr, low, index - 1, k) : quickSort(arr, index + 1, high, k);

    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    public static int getIndex(int[] arr, int low, int high) {

        //暂存基准数据
        int temp = arr[low];

        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= temp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];

            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= temp) {
                low++;
            }

            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = temp;

        //返回tmp的正确位置
        return low;
    }


    //归并排序写
    public static int[] getLeastNumbers(int[] arr, int k) {

        if (arr.length == 0 || k == 0) return new int[0];

        mergeSort(arr);

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }


    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        int t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}