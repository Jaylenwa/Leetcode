package 排序;

/**
 * @author WJL
 * @date: 2021/08/03 19:32
 * <p>
 * 归并排序
 **/

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {18, 9, 3, 1, 5, 3, 7, 1};
        mergeSort(arr);

        for (int anInt : arr) {
            System.out.println(anInt);
        }
    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    public static void mergeSort(int[] arr, int L, int R, int[] temp) {

        if (L == R) return;

        int M = (L + R) / 2;
        mergeSort(arr, L, M, temp);
        mergeSort(arr, M + 1, R, temp);
        merge(arr, L, M, R, temp);
    }

    private static void merge(int[] arr, int L, int M, int R, int[] temp) {
        int i = L;
        int j = M + 1;
        int k = 0;

        while (i <= M && j <= R) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            }
        }

        while (i <= M) {
            temp[k++] = arr[i++];
        }

        while (j <= R) {
            temp[k++] = arr[j++];
        }

        int t = 0;
        while (L <= R) {
            arr[L++] = temp[t++];
        }

    }
}