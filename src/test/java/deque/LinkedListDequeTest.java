package deque;

import com.xiaowei.datastruct.deque.impl.LinkedListDeque;
import org.junit.Test;

import java.util.Date;

public class LinkedListDequeTest {
    @Test
    public void offerFirst() {
        LinkedListDeque<Integer> linkedListQueue = new LinkedListDeque<>(5);
        linkedListQueue.offerFirst(1);
        linkedListQueue.offerFirst(2);
        linkedListQueue.offerFirst(3);
        linkedListQueue.offerEnd(4);
        linkedListQueue.offerEnd(5);
        System.out.println();
    }

    @Test
    public void poolFist() {
        LinkedListDeque<Integer> linkedListQueue = new LinkedListDeque<>(5);
        linkedListQueue.offerFirst(1);
        linkedListQueue.offerFirst(2);
        linkedListQueue.offerFirst(3);
        linkedListQueue.offerEnd(4);
        linkedListQueue.offerEnd(5);

        System.out.println(linkedListQueue.poolFirst());
        System.out.println(linkedListQueue.poolFirst());

        System.out.println(linkedListQueue.poolEnd());
        System.out.println(linkedListQueue.poolEnd());
    }

    @Test
    public void peekEnd() {
        LinkedListDeque<Integer> linkedListQueue = new LinkedListDeque<>(5);
        linkedListQueue.offerFirst(1);
        linkedListQueue.offerFirst(2);
        linkedListQueue.offerFirst(3);
        linkedListQueue.offerEnd(4);
        linkedListQueue.offerEnd(5);

        System.out.println(linkedListQueue.poolFirst());
        System.out.println(linkedListQueue.poolFirst());

        System.out.println(linkedListQueue.peekEnd());
        System.out.println(linkedListQueue.peekEnd());
    }

    @Test
    public void iter() {
        LinkedListDeque<Integer> linkedListQueue = new LinkedListDeque<>(5);
        linkedListQueue.offerFirst(1);
        linkedListQueue.offerFirst(2);
        linkedListQueue.offerFirst(3);
        linkedListQueue.offerEnd(4);
        linkedListQueue.offerEnd(5);

        for (Integer integer : linkedListQueue) {
            System.out.println(integer);
        }
    }

    @Test
    public void testMath() {
        long x = 1;
        String format = String.format("输出【s%】,龙【s%】", new Date(),x);
        System.out.println(format);
    }
}
