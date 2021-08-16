package 链表;

/**
 * @author WJL
 * @date: 2021/08/08 13:57
 **/

public class 两个链表的第一个公共节点 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA;
        }

        return p1;
    }
}