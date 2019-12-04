package queue;

/**
 * @author XiaoXiong
 * @since 2019-11-26
 */
public class ArrayQueue {

    private String[] items;

    /**
     * size
     */
    private int n;

    /**
     * 头指针
     */
    private int head = 0;

    /**
     * 尾指针
     */
    private int tail = 0;


    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        if (n == tail) {
            //队列满了
            if (head == 0) {
                return false;
            }
            //数据迁移  将队列后边的数据移到前面 空出队列后边的位置 使其可以继续入队
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            //数据迁移后 修正队列的头尾指针
            tail -= head;
            head = 0;

        }
        items[tail] = item;
        ++tail;
        return true;
    }


    public String dequeue() {
        //当头指针（数组下标）等于数组大小 说明队列中已无数据 超过了队列容量
        if (n == head) {
            return null;
        }
        String result = items[head];
        ++head;
        return result;
    }
}
