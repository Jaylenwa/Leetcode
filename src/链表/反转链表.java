package 链表;

import jdk.nashorn.internal.ir.LiteralNode;

/**
 * @author WJL
 * @date: 2021/08/07 21:01
 **/

public class 反转链表 {

    public static void main(String[] args) {

        ListNode node = ListNode.getListNode();

        ListNode listNode = reverseList(node);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode res = null;
        ListNode temp = null;

        while (cur != null){
            temp = res;
            res = cur;
            cur = cur.next;
            res.next = temp;
        }

        return res;

    }
}