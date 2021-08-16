package 数组;

/**
 * @author WJL
 * @date: 2021/08/02 15:16
 * 二维数组中的查找
 *
 *当成二叉搜索树来做
 **/

public class 二维数组中的查找 {
    public static void main(String[] args) {

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        int i = matrix.length - 1 , j = 0;

        while(i >= 0 && j < matrix[0].length){
            if(target > matrix[i][j]){
                j++;
            }else if (target < matrix[i][j]){
                i--;
            }else {
                return true;
            }
        }

        return false;
    }

}
