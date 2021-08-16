package 链表;

import java.util.LinkedList;
import java.util.List;


/**
 * @author WJL
 * @date: 2021/08/07 20:14
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 **/

public class 从尾到头打印链表 {

    public static void main(String[] args) {


        ListNode listNode = ListNode.getListNode();

        int[] ints = reversePrint1(listNode);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }



    public static int[] reversePrint(ListNode head) {

        if (head == null) return new int[0];

        LinkedList<Integer> arr = new LinkedList<>();

        while (head != null){
            arr.add(head.val);
            head = head.next;
        }

        int[] res = new int[arr.size()];
        for (int i = arr.size() - 1; i >= 0 ; i--) {
            res[arr.size() - 1 - i] = arr.get(i);
        }

        return res;
    }

    //最优解
    public static int[] reversePrint1(ListNode head) {

        if (head == null) return new int[0];

        ListNode temp = head;

        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }

        int[] res = new int[count];
        while (head != null){
            res[--count] = head.val;
            head = head.next;
        }

        return res;
    }
}