package 链表;

/**
 * @author WJL
 * @date: 2021/08/07 21:28
 * 合并两个排序的链表
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 **/

public class 合并两个排序的链表 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode();

        ListNode node = mergeTwoLists(listNode, listNode);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode result = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }

        res.next = l1 != null ? l1 : l2;
        return result.next;
    }
}