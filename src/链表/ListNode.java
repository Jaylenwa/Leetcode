package 链表;

import java.util.List;

/**
 * @author WJL
 * @date: 2021/08/07 20:15
 **/

public class ListNode {

    public int val;
    public ListNode next;

    public static ListNode getListNode(){
        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node = new ListNode(1,node2);
        return node;
    }

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}