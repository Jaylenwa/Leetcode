package 数组;

/**
 * @author WJL
 * @date: 2021/08/03 12:13
 * 数组中的逆序对
 * <p>
 * 解题思路 先给数组归并排序 在合并的过程中,计算arr[i] > arr[j]的对数
 **/

public class 数组中的逆序对 {

    private int res = 0;

    public static void main(String[] args) {
        数组中的逆序对 test = new 数组中的逆序对();
        int[] arr = {3, 4, 1, 2, 9, 1, 1, 3, 4, 1, 2, 9, 1, 1, 3};

        int i = test.reversePairs(arr);
        System.out.println(i);
    }

    public int reversePairs(int[] nums) {

        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return res;
    }

    public void mergeSort(int[] arr, int left, int right, int[] temp) {

        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);

    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                res += mid + 1 - i;//核心代码
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