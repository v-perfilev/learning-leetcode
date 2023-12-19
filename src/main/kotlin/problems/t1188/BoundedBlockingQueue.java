package problems.t1188;

import java.util.Deque;
import java.util.LinkedList;

class BoundedBlockingQueue {
    private final Deque<Integer> content;
    private final int capacity;
    private volatile int size;

    public BoundedBlockingQueue(int capacity) {
        this.content = new LinkedList<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void enqueue(int element) throws InterruptedException {
        while (this.size == this.capacity) {
            wait();
        }
        content.addLast(element);
        this.size++;
        notifyAll();
    }

    public synchronized int dequeue() throws InterruptedException {
        while (this.size == 0) {
            wait();
        }
        int element = content.removeFirst();
        this.size--;
        notifyAll();
        return element;
    }

    public synchronized int size() {
        return this.size;
    }

}
