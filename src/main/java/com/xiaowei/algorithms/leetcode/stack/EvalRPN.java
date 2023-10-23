package com.xiaowei.algorithms.leetcode.stack;

import com.xiaowei.datastruct.stack.ArrayStack;

/**
 * @author weiguowei
 * 逆波兰表达式，解题思路，将数字压栈，遇到运算符将前两个数据拿出来计算，然后在压入栈
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/" ></a>
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        ArrayStack<Integer> stack = new ArrayStack<>(tokens.length);
        for (String i : tokens) {
            switch (i){
                case "+" : {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(b + a);
                    break;
                }

                case "-" : {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a - b);
                    break;
                }

                case "*" : {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(b * a);
                    break;
                }

                case "/" : {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a / b);
                    break;
                }

                default: {
                    stack.push(Integer.valueOf(i));
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(new EvalRPN().evalRPN(tokens));
    }
}
