package queue;


import org.junit.Test;

/**
 * @author XiaoXiong
 * @since 2019-11-26
 */
public class ArrayQueueTest {


    @Test
    public void arrayQueueTest() {

        ArrayQueue arrayQueue = new ArrayQueue(5);

        for (int i = 0; i < 5; i++) {
            arrayQueue.enqueue(i + "");
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(arrayQueue.dequeue());
        }

    }


}
