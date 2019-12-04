package queue;

/**
 * 循环队列
 *
 * @author XiaoXiong
 * @since 2019-11-26
 */
public class CircularQueue {

    private String[] items;

    private int head = 0;

    private int tail = 0;

    private int n;

    public CircularQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }


    private boolean enqueue(String item) {

        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;

    }

    private String dequeue() {
        if (head == tail) {
            return null;
        }

        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }


}
