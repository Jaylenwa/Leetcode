package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WJL
 * @date: 2021/08/07 22:18
 * 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 要保持原链表不变
 **/

public class 复杂链表的复制 {

    public static void main(String[] args) {
        Node node1 = new Node(2, null, null);
        Node node = new Node(1, node1, node1);

        copyRandomList2(node);


    }

    public static Node copyRandomList2(Node head){
//  1  2  3  4  5
        if (head == null) return null;

        Node cur = head;

        while (cur != null){
            Node tep = new Node(cur.val);
            tep.next = cur.next;
            cur.next = tep;
            cur = tep.next;
        }

        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;//指向的是新复制的那个
            }
            cur = cur.next.next;
        }

        cur = head.next;
        Node pre = head , res = head.next;

        while(cur.next != null){
            pre.next= pre.next.next;
            cur.next = cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = null;
        return res;

    }

    public Node copyRandomList(Node head) {

        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node cur = head;

        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}