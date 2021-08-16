package 树;

/**
 * @author WJL
 * @date: 2021/08/11 14:33
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
 * 否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 后序遍历定义： [ 左子树 | 右子树 | 根节点 ] ，即遍历顺序为 “左、右、根” 。
 * 二叉搜索树定义： 左子树中所有节点的值 << 根节点的值；右子树中所有节点的值 >> 根节点的值；其左、右子树也分别为二叉搜索树。
 *
 **/

public class 二叉搜索树的后序遍历序列 {

    public boolean verifyPostorder(int[] postorder) {

        //todo
        //1,3,2,6,5

        //方法区 虚拟机栈  程序计数器  堆 本地方法栈
        return false;
    }

    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }

        // 1 3 2 6 5
        boolean recur(int[] postorder, int i, int j) {
            if(i >= j) return true;
            int p = i;
            while(postorder[p] < postorder[j]) p++;
            int m = p;
            while(postorder[p] > postorder[j]) p++;
            return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
        }
    }
}