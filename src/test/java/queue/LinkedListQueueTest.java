package queue;

import com.xiaowei.datastruct.queue.impl.LinkedListQueue;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author weiguowei
 * 测试单项环形链表实现队列
 */

public class LinkedListQueueTest<E> {

    @Test
    public void offer(){
        LinkedListQueue<Integer> integerLinkedListQueue = new LinkedListQueue<>();
        integerLinkedListQueue.offer(1);
        integerLinkedListQueue.offer(2);
        integerLinkedListQueue.offer(3);
        integerLinkedListQueue.offer(4);
        integerLinkedListQueue.offer(5);

        assertIterableEquals(Arrays.asList(1,2,3,4,5),integerLinkedListQueue);
    }

    @Test
    public void poll(){
        LinkedListQueue<Integer> integerLinkedListQueue = new LinkedListQueue<>();
        integerLinkedListQueue.offer(1);
        integerLinkedListQueue.offer(2);
        Integer poll = integerLinkedListQueue.poll();
        integerLinkedListQueue.poll();
        assertIterableEquals(Arrays.asList(),integerLinkedListQueue);
        System.out.println(poll);
    }
    @Test
    public void peek(){
        LinkedListQueue<Integer> integerLinkedListQueue = new LinkedListQueue<>();
        integerLinkedListQueue.offer(1);
        integerLinkedListQueue.offer(2);
        integerLinkedListQueue.offer(3);

        Integer peek = integerLinkedListQueue.peek();
        assertIterableEquals(Arrays.asList(1,2,3),integerLinkedListQueue);
        System.out.println(peek);
    }

    @Test
    public void full(){
        LinkedListQueue<Integer> integerLinkedListQueue = new LinkedListQueue<>(3);
        integerLinkedListQueue.offer(1);
        integerLinkedListQueue.offer(2);
        integerLinkedListQueue.offer(3);
        System.out.println(integerLinkedListQueue.size());
    }
    @Test
    public void empty(){
        LinkedListQueue<Integer> integerLinkedListQueue = new LinkedListQueue<>(3);
        integerLinkedListQueue.offer(1);
        integerLinkedListQueue.offer(2);
        integerLinkedListQueue.offer(3);
        Integer poll = integerLinkedListQueue.poll();
        integerLinkedListQueue.poll();
        integerLinkedListQueue.poll();
        System.out.println(integerLinkedListQueue.poll());
        System.out.println(poll);
    }
    @Test
    public void iterable(){
        LinkedListQueue<Integer> integerLinkedListQueue = new LinkedListQueue<>();
        integerLinkedListQueue.offer(1);
        integerLinkedListQueue.offer(2);
        integerLinkedListQueue.offer(3);
        integerLinkedListQueue.offer(4);
        integerLinkedListQueue.offer(5);
        integerLinkedListQueue.offer(6);
        integerLinkedListQueue.offer(7);
        integerLinkedListQueue.offer(8);
        integerLinkedListQueue.offer(9);

        for (Integer integer : integerLinkedListQueue) {
            System.out.println(integer);
        }
    }
}
