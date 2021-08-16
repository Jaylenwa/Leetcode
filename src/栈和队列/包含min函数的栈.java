package 栈和队列;

import java.util.Stack;

/**
 * @author WJL
 * @date: 2021/08/08 21:23
 **/

public class 包含min函数的栈 {

    Stack<Integer> A = new Stack<Integer>();
    Stack<Integer> B = new Stack<Integer>();//max

    public 包含min函数的栈() {

    }

    public void push(int x) {
        A.push(x);

        if (B.isEmpty() || x <= B.peek()) {
            B.push(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}