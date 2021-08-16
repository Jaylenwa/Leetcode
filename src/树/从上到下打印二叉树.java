package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WJL
 * @date: 2021/08/11 14:17
 *
 **/

public class 从上到下打印二叉树 {

    public int[] levelOrder(TreeNode root) {

        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> arr = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            arr.add(poll.val);
                if (poll.left != null){
                    queue.add(poll.left);
            }

            if (poll.right != null){
                queue.add(poll.right);
            }
        }

        int i = 0;
        int[] res = new int[arr.size()];

        for (Integer integer : arr) {
            res[i++] = integer;
        }
        return res;
    }

}

