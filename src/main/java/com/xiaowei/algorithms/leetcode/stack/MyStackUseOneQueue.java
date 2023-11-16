package com.xiaowei.algorithms.leetcode.stack;

import com.xiaowei.datastruct.queue.impl.LinkedListQueue;

/**
 * @author weiguowei
 * 使用单队列实现栈
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/description/" ></a>
 */
public class MyStackUseOneQueue {
    LinkedListQueue<Integer> queue = new LinkedListQueue<>(100);

    private int size = 0;

    public void push(int x) {
        if (queue.isEmpty()) {
            queue.offer(x);
        }else {
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }
        size++;
    }

    public int pop() {
        size--;
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStackUseOneQueue myStack = new MyStackUseOneQueue();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        myStack.empty();
    }
}
