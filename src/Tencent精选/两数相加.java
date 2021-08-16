package Tencent精选;

import 链表.ListNode;

/**
 * @author WJL
 * @date: 2021/08/12 09:58
 **/

public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode tep = new ListNode(0);
        ListNode res = tep;
        int sum;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            sum = v2 + v1 + carry;

            tep.next = new ListNode(sum % 10);
            tep = tep.next;

            carry = sum / 10;

            if (l1 == null) {
                l2 = l2.next;
            }

            if (l2 == null) {
                l1 = l1.next;
            }
        }

        if (carry > 0) {
            tep.next = new ListNode(carry);
        }
        return res.next;
    }
}