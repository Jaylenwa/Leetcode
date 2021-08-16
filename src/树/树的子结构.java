package 树;

/**
 * @author WJL
 * @date: 2021/08/11 11:19
 **/

public class 树的子结构 {

    //FIXME 重点 可能会考察到


    public boolean isSubStructure2(TreeNode A, TreeNode B) {

        if (A == null || B == null) return false;

        //以 节点 A 为根节点的子树 包含树 B ，对应 recur(A, B)；
        if (recur(A, B)) {
            return true;
        }

        //树 B 是 树 A 左子树 的子结构，对应 isSubStructure(A.left, B)；
        //树 B 是 树 A 右子树 的子结构，对应 isSubStructure(A.right, B)；
        return isSubStructure2(A.left, B) || isSubStructure2(A.right, B);

        //下面一句可以代替上面所有 但是不直观
//        return (A!= null && B!= null) && recur(A,B) || isSubStructure2(A.left,B) || isSubStructure2(A.right,B);
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;

        if (A == null || A.val != B.val) return false;

        return recur(A.left, B) && recur(A.right, B);
    }

}