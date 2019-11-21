package linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author XiaoXiong
 * @since 2019-11-14
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //哑结点
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        int length = 0;

        ListNode first = head;

        //先算出整个链表的长度
        while (first != null) {
            length++;
            first = first.next;
        }

        //要删除节点的位置
        length -= n;

        first = dummy;

        while (length > 0) {
            length--;
            first = first.next;
        }

        //删除节点
        first.next = first.next.next;

        return dummy.next;
    }


    public ListNode method2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        //first往后走两步
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        //first second 同时往后走，当first为null时，second到了要删除的节点的前一个节点处
        while (first != null) {
            second = second.next;
            first = first.next;
        }

        //这里实际改的是head
        second.next = second.next.next;


        return dummy.next;
//        return head;
    }


    @Test
    public void testRemoveNthFromEnd() {

        ListNode testListNode = new ListNode(1);
        testListNode.next = new ListNode(2);
        testListNode.next.next = new ListNode(3);
        testListNode.next.next.next = new ListNode(4);


//        ListNode result = removeNthFromEnd(testListNode, 2);
        ListNode result = method2(testListNode, 4);

        Assert.assertEquals(result.val, 2);
        Assert.assertEquals(result.next.val, 3);
        Assert.assertEquals(result.next.next.val, 4);


    }



}
