package 数组;

/**
 * @author WJL
 * @date: 2021/08/02 17:39
 *
 * 顺时针打印矩阵
 *
 * 四个方位的定义是从上到下是matrix.length - 1，从左到右是matrix[0].length - 1
 *
 * 循环的时候比如 left -> right 是循环的 top 边
 **/

public class 顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {


        if (matrix.length == 0) return new int[0];

        int left = 0, right = matrix[0].length - 1, top = 0, button = matrix.length - 1, x = 0;

        int[] res = new int[(right + 1) * (button + 1)];
        while (true) {
            for (int i = left; i <= right; i++) {
                res[x++] = matrix[top][i];
            }
            if (++top > button) break;

            for (int i = top; i <= button; i++) {
                res[x++] = matrix[i][right];
            }
            if (left > --right) break;

            for (int i = right; i >= left; i--) {
                res[x++] = matrix[button][i];
            }
            if (top > --button) break;

            for (int i = button; i >= top; i--) {
                res[x++] = matrix[i][left];
            }
            if (++left > right) break;
        }

        return res;

    }

}