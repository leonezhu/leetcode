package linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * @author XiaoXiong
 * @since 2019-12-27
 */
public class SwapPairs {


    public ListNode swapPairs(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;

        head.next = swapPairs(next.next);

        next.next = head;

        return next;

    }


    @Test
    public void test() {

        ListNode l = new ListNode(4);
        l.next = new ListNode(3);
        l.next.next = new ListNode(5);
        l.next.next.next = new ListNode(6);

        ListNode result = swapPairs(l);

        Assert.assertEquals(3, result.val);
        Assert.assertEquals(4, result.next.val);
        Assert.assertEquals(6, result.next.next.val);
        Assert.assertEquals(5, result.next.next.next.val);


    }
}
