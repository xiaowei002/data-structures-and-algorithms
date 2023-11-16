package com.xiaowei.algorithms.leetcode.stack;

import com.xiaowei.datastruct.stack.impl.ArrayStack;

/**
 * @author weiguowei
 * 用两个栈实现队列，A栈作为队列尾部，A栈直接push，在pop时先将A栈中的数据转入B栈，B栈作为队列头部
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks/" ></a>
 */
class MyQueue {
    //栈A（队列尾部）
    ArrayStack<Integer> stackA = new ArrayStack<Integer>(100);
    //栈A（队列头部）
    ArrayStack<Integer> stackB = new ArrayStack<Integer>(100);


    public MyQueue() {

    }
    
    public void push(int x) {
        stackA.push(x);
    }
    
    public int pop() {
        if(stackB.isEmpty()){
            while (!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }
    
    public int peek() {
        if(stackB.isEmpty()){
            while (!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }
    
    public boolean empty() {
        return stackB.isEmpty() && stackA.isEmpty();
    }
}