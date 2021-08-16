package 栈和队列;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author WJL
 * @date: 2021/08/08 17:47
 **/

public class 用两个栈实现队列 {


    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public 用两个栈实现队列() {

    }

    public void appendTail(int value) {
        A.push(value);
    }

    public int deleteHead() {

        if (!B.empty()){
            return B.pop();
        }

        if (A.empty()){
            return -1;
        }

        while (!A.empty()){
            B.push(A.pop());
        }

        return B.pop();
    }
}