package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author WJL
 * @date: 2021/08/10 16:38
 * <p>
 * 前序遍历 -> 根左右
 * 后序遍历左右根 后续遍历可以转化为 根右左存储 然后倒序输出
 **/

public class 二叉树的前_中_后序遍历 {

    //莫里斯遍历
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode pre = null;
        while (root != null) {
            //如果左节点不为空，就将当前节点连带右子树全部挂到
            //左节点的最右子树下面
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                //将root指向root的left
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
                //左子树为空，则打印这个节点，并向右边遍历
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    //用栈模拟递归实现  中序遍历
    public List<Integer> inorderTraversal5(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.size() > 0) {
            if (root != null) {
                res.add(root.val);

            } else {

            }
        }
        return res;
    }

    //用栈模拟递归实现
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.size() > 0) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode tep = stack.pop();
                res.add(tep.val);
                root = tep.right;
            }
        }
        return res;
    }

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        dfs(res, root);
        return res;
    }

    private void dfs(ArrayList<Integer> res, TreeNode root) {
        if (root == null) return;
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }

    //前序遍历
    public List<Integer> inorderTraversal6(TreeNode root) {
        if (root == null) return null;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    //后序遍历
    public List<Integer> inorderTraversal4(TreeNode root) {
        if (root == null) return null;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stackRes = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            stackRes.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!stackRes.isEmpty()) {
            res.add(stackRes.pop().val);
        }
        return res;
    }
}