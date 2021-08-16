package 链表;

/**
 * @author WJL
 * @date: 2021/08/08 16:15
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除所有重复的元素，使每个元素 只出现一次 。
 **/

public class 删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode temp = head;
        while(temp.next != null){
            if (temp.val == temp.next.val){
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return head;
    }


}