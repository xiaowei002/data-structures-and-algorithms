package com.xiaowei.algorithms.leetcode.stack;

import com.xiaowei.datastruct.queue.LinkedListQueue;
import com.xiaowei.datastruct.stack.ArrayStack;

/**
 * @author weiguowei
 * 用两个队列实现栈
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/" ></a>
 */
class MyStack {

    public MyStack() {

    }

    LinkedListQueue<Integer> queue1 = new LinkedListQueue<>(100);
    LinkedListQueue<Integer> queue2 = new LinkedListQueue<>(100);


    public void push(int x) {
        if(queue1.isEmpty()){
            queue1.offer(x);
        }else {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                queue2.offer(queue1.poll());
            }
            queue1.offer(x);
            int size1 = queue2.size();
            for (int j = 0; j < size1; j++) {
                queue1.offer(queue2.poll());
            }
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
    }
}