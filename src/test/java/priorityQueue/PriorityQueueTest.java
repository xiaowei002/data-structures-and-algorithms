package priorityQueue;

import com.xiaowei.datastruct.priorityqueue.Priority;
import com.xiaowei.datastruct.priorityqueue.impl.PriorityQueue;
import org.junit.Test;

/**
 * @author weiguowei
 * 测试优先级队列（无序数组）
 */
public class PriorityQueueTest {
    @Test
    public void test(){
        PriorityQueue<Entity> priorityQueue = new PriorityQueue<>(5);
        priorityQueue.offer(new Entity(1,1));
        priorityQueue.offer(new Entity(2,2));
        priorityQueue.offer(new Entity(3,3));
        priorityQueue.offer(new Entity(4,4));
        priorityQueue.offer(new Entity(5,5));

        Entity poll = priorityQueue.poll();
        System.out.println(poll.getValue());
        System.out.println(poll.priority());
    }
}
