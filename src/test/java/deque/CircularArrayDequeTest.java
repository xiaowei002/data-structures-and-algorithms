package deque;

import com.xiaowei.datastruct.deque.ArrayDeque;
import com.xiaowei.datastruct.deque.LinkedListDeque;
import org.junit.Test;

import java.util.Date;

public class CircularArrayDequeTest {
    @Test
    public void offerFirst() {
        ArrayDeque<Integer> linkedListQueue = new ArrayDeque<>(6);
        linkedListQueue.offerFirst(1);
        linkedListQueue.offerFirst(2);
        linkedListQueue.offerFirst(3);
        linkedListQueue.offerEnd(4);
        linkedListQueue.offerEnd(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(linkedListQueue.poolFirst());
        }
    }

    @Test
    public void poolFist() {
        ArrayDeque<Integer> linkedListQueue = new ArrayDeque<>(6);
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
        LinkedListDeque<Integer> linkedListQueue = new LinkedListDeque<>(6);
        linkedListQueue.offerFirst(1);
        linkedListQueue.offerFirst(2);
        linkedListQueue.offerFirst(3);
        linkedListQueue.offerEnd(4);
        linkedListQueue.offerEnd(5);

        for (Integer integer : linkedListQueue) {
            System.out.println(integer);
        }
    }
}
