package linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author XiaoXiong
 * @since 2019-11-21
 */
public class MergeTwoLists {


        //TODO 错误 ：当输入以下时 输出：[1,5,2,4]

        // [5]
        //[1,2,4]
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode head = dummy;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    head.next = new ListNode(l2.val);
                    head.next.next = new ListNode(l1.val);
                } else {
                    head.next = new ListNode(l1.val);
                    head.next.next = new ListNode(l2.val);
                }
                l1 = l1.next;
                l2 = l2.next;
                head = head.next.next;
            } else if (l1 == null) {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
                head = head.next;
            } else if (l2 == null) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
                head = head.next;
            } else {
                return dummy.next;
            }


        }
        return dummy.next;
    }

    @Test
    public void testRemoveNthFromEnd() {




        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        //预期结果 1->1->2->3-3->4

        ListNode result = mergeTwoLists(l1, l2);

        Assert.assertEquals(result.val, 1);
        Assert.assertEquals(result.next.val, 1);
        Assert.assertEquals(result.next.next.val, 2);
        Assert.assertEquals(result.next.next.next.val, 3);
        Assert.assertEquals(result.next.next.next.next.val, 3);
        Assert.assertEquals(result.next.next.next.next.next.val, 4);


    }


}
