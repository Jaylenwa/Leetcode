package 链表;

/**
 * @author WJL
 * @date: 2021/08/07 22:20
 **/

public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}