package 排序;

import java.util.ArrayList;

/**
 * @author WJL
 * @date: 2021/08/09 09:54
 **/

public class QuickSort {

    public static void main(String[] args) {
//        int[] s = new int[100000];
//
//        for (int i = 0; i < 100000; i++) {
//            s[i] = i;
//        }
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] b = {1,5,4,3,2,1};
        quickSort(b,0,b.length - 1);

        for (int i : b) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0) return;
        if (low >= high) return;
        // 找寻基准数据的正确索引
        int index = getIndex(arr,low,high);

        // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
        quickSort(arr,low,index - 1); //切记是low不是0 两者性能差距是指数级别的
        quickSort(arr,index + 1,high);
    }

    public static int getIndex(int[] arr, int low, int high) {
//                       4
        //int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        //暂存基准数据
        int temp = arr[low];

        while (low < high){
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= temp){
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];

            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= temp){
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


}