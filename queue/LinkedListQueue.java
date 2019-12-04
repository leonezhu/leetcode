package queue;

import linkedlist.ListNode;

/**
 * @author XiaoXiong
 * @since 2019-11-26
 */
public class LinkedListQueue {

    private ListNode head = null;

    private ListNode tail = null;

    public void enqueue(int value) {
        ListNode listNode = new ListNode(value, null);
        if (tail == null) {
            head = listNode;
            tail = listNode;
        } else {
            tail.next = new ListNode(value, null);
            tail = tail.next;
        }
    }

    public int dequeue() {
        if (head == null) {
            return -1;
        }

        int value = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;

    }


}
