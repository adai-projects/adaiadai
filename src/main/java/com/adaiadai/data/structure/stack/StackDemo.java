package com.adaiadai.data.structure.stack;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        /* 初始化栈 */
        Stack<Integer> stack = new Stack<>();

        /* 元素入栈 */
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        /* 访问栈顶元素 */
        int peek = stack.peek();

        /* 元素出栈 */
        int pop = stack.pop();

        /* 获取栈的长度 */
        int size = stack.size();

        /* 判断是否为空 */
        boolean isEmpty = stack.isEmpty();
    }

}
