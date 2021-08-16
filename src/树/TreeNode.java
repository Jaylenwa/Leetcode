package 树;

/**
 * @author WJL
 * @date: 2021/08/10 14:49
 **/

public class TreeNode {

    public int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode parent, TreeNode left, TreeNode right) {
        this.val = val;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}