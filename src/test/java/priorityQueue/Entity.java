package priorityQueue;

import com.xiaowei.datastruct.priorityqueue.Priority;

public class Entity implements Priority {
    private int value;
    private int priority;

    public Entity(int value,int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return this.priority;
    }

    public int getValue() {
        return value;
    }
}
