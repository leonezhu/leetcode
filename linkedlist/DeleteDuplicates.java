package linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author XiaoXiong
 * @since 2019-12-27
 */
public class DeleteDuplicates {


    public static ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }


    @Test
    public void test() {

        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(3);


        ListNode result = deleteDuplicates(l);

        Assert.assertEquals(1, result.val);
        Assert.assertEquals(2, result.next.val);
        Assert.assertEquals(3, result.next.next.val);

    }
}
