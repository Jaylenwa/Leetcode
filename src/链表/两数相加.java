package 链表;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WJL
 * @date: 2021/08/11 15:48
 *
 **/

public class 两数相加 {

    public static void main(String[] args) {

        ListNode listNode = ListNode.getListNode();
        ListNode node = addTwoNumbers(listNode,listNode);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode tep = res;
        while (l1 != null || l2 != null) {

            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;

            int sum = n1 + n2 + carry;

            res.next = new ListNode(sum % 10);

            res = res.next;

            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            res.next = new ListNode(carry);
        }
        return tep.next;
    }
}
