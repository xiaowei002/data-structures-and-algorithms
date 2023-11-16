package com.xiaowei.algorithms.leetcode.stack;

import com.xiaowei.datastruct.stack.impl.LinkedListStack;

/**
 * @author weiguowei
 * 中缀表达式转换为后缀表达式
 * 遇到非运算符，直接拼串
 * 遇到+,-,*,/
 * - 当前优先级高于栈顶运算符，入栈
 * - 否则将栈中优先级>=当前的都出栈，然后当前运算符再入栈
 * 遍历完成，栈中元素依次出栈
 * 带（）
 * 左括号直接入栈
 * 有括号就把栈中直到左括号的为止的所有运算符出栈。
 */
public class InfixToSuffix {
    private String infixToSuffix(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<>(s.length());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '/':
                case '*':
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else if (priority(c) > priority(stack.peek())) {
                        stack.push(c);
                    } else {
                        while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                            stringBuilder.append(stack.pop());
                        }
                        stack.push(c);
                    }
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '('){
                        stringBuilder.append(stack.pop());
                        stack.pop();
                    }
                default:
                    stringBuilder.append(c);
            }
        }
        return String.valueOf(stringBuilder);
    }

    /**
     * 返回字符优先级
     *
     * @param c
     * @return
     */
    static int priority(char c) {
        int i = -1;
        switch (c) {
            case '*':
            case '/': {
                i = 2;
                break;
            }
            case '+':
            case '-': {
                i = 1;
                break;
            }
            case '(': {
                i = 0;
                break;
            }
        }
        return i;
    }
}
