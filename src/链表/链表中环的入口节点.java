package 链表;

import java.util.List;

/**
 * @author WJL
 * @date: 2021/08/08 14:49
 **/

public class 链表中环的入口节点 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode();

    }

    public ListNode detectCycle(ListNode head) {


        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) { //走了这个说明有环，没走说明head不为空但是没环
                break;
            }
        }

        if (fast == null || fast.next == null){ //说明head不为空，但是没有环
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;

    }
}