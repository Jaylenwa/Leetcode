package 链表;

/**
 * @author WJL
 * @date: 2021/08/08 16:29
 * <p>
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除链表中所有存在数字重复情况的节点，
 * 只保留原始链表中 没有重复出现 的数字
 **/

public class 删除排序链表中的重复元素II {

    //FIXME  经典题

    //迭代法
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode preHead  = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = head;

        while (cur != null){
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }

            if (pre.next == cur){
                pre = pre.next;
            }else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return preHead.next;

    }


        //递归法
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            ListNode temp = head.next;
            while (temp != null && head.val == temp.val) {
                temp = temp.next;
            }
            return deleteDuplicates(temp);
        }
        return head;
    }
}