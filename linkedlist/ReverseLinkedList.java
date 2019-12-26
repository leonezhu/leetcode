package linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author XiaoXiong
 * @since 2019-12-26
 */
public class ReverseLinkedList {


    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;

        ListNode curr = head;

        while (curr != null) {

            ListNode temp = curr.next;

            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        return prev;
    }


    //TODO 递归解法


    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(1);

        ListNode result = reverseList(l1);

        Assert.assertEquals(l2.val, result.val);
        Assert.assertEquals(l2.next.val, result.next.val);
        Assert.assertEquals(l2.next.next.val, result.next.next.val);


    }


}
