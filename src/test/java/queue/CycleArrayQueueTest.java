package queue;

import com.xiaowei.datastruct.queue.impl.CycleArrayQueue;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * @author weiguowei
 * 测试环型数组实现队列
 */

public class CycleArrayQueueTest<E> {

    @Test
    public void offer(){
        CycleArrayQueue<Integer> integerLinkedListQueue = new CycleArrayQueue<>(5);
        integerLinkedListQueue.offer(1);
        integerLinkedListQueue.offer(2);
        integerLinkedListQueue.offer(3);
        integerLinkedListQueue.offer(4);
        integerLinkedListQueue.offer(5);

        for (Integer integer : integerLinkedListQueue) {
            System.out.println(integer);
        }
    }

    @Test
    public void poll(){
        CycleArrayQueue<Integer> integerLinkedListQueue = new CycleArrayQueue<>(4);
        integerLinkedListQueue.offer(1);
        integerLinkedListQueue.offer(2);
        Integer poll = integerLinkedListQueue.poll();
        integerLinkedListQueue.poll();
//        assertIterableEquals(Arrays.asList(null,null),integerLinkedListQueue);
        System.out.println(poll);
        for (Integer integer : integerLinkedListQueue) {
            System.out.println(integer);
        }
    }
    @Test
    public void peek(){
        CycleArrayQueue<Integer> integerLinkedListQueue = new CycleArrayQueue<>(3);
        integerLinkedListQueue.offer(1);
        integerLinkedListQueue.offer(2);
        integerLinkedListQueue.offer(3);

        Integer peek = integerLinkedListQueue.peek();
        assertIterableEquals(Arrays.asList(1,2,3),integerLinkedListQueue);
        System.out.println(peek);
    }

    @Test
    public void full(){
        CycleArrayQueue<Integer> integerLinkedListQueue = new CycleArrayQueue<>(3);
        integerLinkedListQueue.offer(1);
        integerLinkedListQueue.offer(2);
        integerLinkedListQueue.offer(3);
        System.out.println(integerLinkedListQueue.isFull());
    }
    @Test
    public void empty(){
        CycleArrayQueue<Integer> integerLinkedListQueue = new CycleArrayQueue<>(3);
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
        CycleArrayQueue<Integer> integerLinkedListQueue = new CycleArrayQueue<>(10);
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
