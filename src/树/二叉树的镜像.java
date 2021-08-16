package 树;

import java.util.Stack;
import java.util.TreeMap;

/**
 * @author WJL
 * @date: 2021/08/11 13:51
 **/

public class 二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;

        return revers(root);
    }

    public TreeNode revers(TreeNode root) {
        if (root == null) return null;

        TreeNode left = revers(root.right);
        TreeNode right = revers(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {

        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tep = node.left;
            node.left = node.right;
            node.right = tep;

            if (node.left != null){
                stack.push(node.left);
            }

            if (node.right !=null){
                stack.push(node.right);
            }
        }

        return root;
    }

}