package queue;

import com.xiaowei.datastruct.queue.LinkedListQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
}
