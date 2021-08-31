package 排序;

/**
 * @author WJL
 * @date: 2021/08/10 11:12
 **/

public class 把数组排成最小的数 {
    /**
     * 4
     * 输入: [3,30,34,5,9]   457 574
     * 输出: "3033459"
     * <p>
     * 排序规则
     * 若拼接字符串 x + y > y + xx+y>y+x ，则 xx “大于” yy ；
     * 反之，若 x + y < y + xx+y<y+x ，则 xx “小于” yy ；、
     * <p>
     * 核心思想 ： 修改比较方法
     */

    public static void main(String[] args) {
        把数组排成最小的数 tep = new 把数组排成最小的数();
        int[] arr = {0, 1};
        String s = tep.minNumber(arr);

        System.out.println(s);
    }

    //快排
    public String minNumber(int[] arr) {

        String[] str = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str[i] = String.valueOf(arr[i]);
        }

        quickSort(str, 0, arr.length - 1);

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : str) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    private static void quickSort(String[] arr, int low, int high) {
        if (arr.length == 0) return;
        if (low >= high) return;
        int index = getIndex(arr, low, high);
        quickSort(arr, low, index - 1);
        quickSort(arr, index + 1, high);

    }


    //   2 3 4 5 3 6
    private static int getIndex(String[] arr, int low, int high) {
        String temp = arr[low];

        while (low < high) {

            //修改比较方式为(temp + arr[high]).compareTo(arr[high] + temp)
            while (low < high && (temp + arr[high]).compareTo(arr[high] + temp) <= 0) {
                high--;
            }

            arr[low] = arr[high];

            while (low < high && (arr[low] + temp).compareTo(temp + arr[low]) <= 0) {
                low++;
            }

            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}