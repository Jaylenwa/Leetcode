package 树;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author WJL
 * @date: 2021/08/10 14:48
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * // 根 左 右   3 9 20 15 7
 * // 左 根 右   9 3 15 20 7
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 思路：
 **/

public class 重建二叉树 {

    int[] preorder;//保留的先序遍历

    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preorder = preorder;//使用this就可以不把preorder传入递归 是个小技巧 更简洁
        for (int i = 0; i < inorder.length; i++) {
            // 使用hashmap存储中序遍历值对应的下标 前序遍历的根值可以快速定位到中序遍历中对应值的位置
            map.put(inorder[i], i);
        }
        return recursive(0, 0, inorder.length - 1);
    }
    /**
     * @param pre_root_index 前序遍历数组中的根节点
     * @param in_left_index  中序遍历数组的left
     * @param in_right_index 中序遍历数组的 right
     * @return 返回root
     */
    public TreeNode recursive(int pre_root_index, int in_left_index, int in_right_index) {

        if (in_left_index > in_right_index) return null;

        //获取根节点 根节点就是先序遍历的第一个位置
        TreeNode root = new TreeNode(preorder[pre_root_index]);

        //获取根节点在中序遍历中的位置
        int index = map.get(preorder[pre_root_index]);

        // 根 左 右   3 9 20 15 7 前
        // 左 根 右   9 3 15 20 7 中

        //左子树根节点为前序遍历根节点+1
        //左子树左边界为in_left_index
        //左子树右边界为中序遍历中根节点值-1
        root.left = recursive(pre_root_index + 1, in_left_index, index - 1);

        //右子树根节点为先序遍历根节点位置 + (中序遍历中根节点值位置 - 左边界) + 1
        //右子树左边界为中序遍历中根节点值位置 + 1
        //右子树有边界为in_right_index
        root.right = recursive(pre_root_index + (index - in_left_index) + 1, index + 1, in_right_index);

        return root;
    }
}