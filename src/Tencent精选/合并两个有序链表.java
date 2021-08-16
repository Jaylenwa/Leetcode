package Tencent精选;

import 链表.ListNode;

/**
 * @author WJL
 * @date: 2021/08/12 16:45
 **/

public class 合并两个有序链表 {


    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode();
        mergeTwoLists2(listNode,listNode);
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode tep = res;
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
        res.next = l1 == null ? l2 : l1;
        return tep.next;
    }
}