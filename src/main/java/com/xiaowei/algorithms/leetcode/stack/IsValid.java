package com.xiaowei.algorithms.leetcode.stack;

import com.xiaowei.datastruct.stack.impl.LinkedListStack;

/**
 * @author weiguowei
 * 有效的括号，如果是左括号，入栈对应的右括号，如果是右括号，判断栈顶元素与当前字符是否相等，相同则为一对
 * <a href="https://leetcode.cn/problems/valid-parentheses/" ></a>
 */
public class IsValid {

    public boolean isValid(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<>(s.length());
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}
