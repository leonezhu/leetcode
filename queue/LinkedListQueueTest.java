package queue;

import org.junit.Test;

/**
 * @author XiaoXiong
 * @since 2019-11-26
 */
public class LinkedListQueueTest {

    @Test
    public void linkedListQueueTest() {

        LinkedListQueue queue = new LinkedListQueue();

        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeue());
        }
    }


    @Test
    public void test() {
        System.out.println(2 & 3);
        System.out.println(3 & 3);
        System.out.println(3 & 4);
        System.out.println(4 & 4);
        System.out.println(4 & 3);
    }

}
