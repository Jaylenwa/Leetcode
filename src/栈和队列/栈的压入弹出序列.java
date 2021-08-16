package 栈和队列;

import java.util.Stack;

/**
 * @author WJL
 * @date: 2021/08/08 21:56
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 建立辅助栈来判断弹出栈
 **/

public class 栈的压入弹出序列 {

    public static void main(String[] args) {
        validateStackSequences2(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;

        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }


    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for (int e : pushed) {
            pushed[i] = e;
            while (i >= 0 && pushed[i] == popped[j]) {
                j++;
                i--;
            }
            i++;
        }
        return i == 0;

    }

}