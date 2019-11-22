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


    /**
     * 自己写的迭代。。。0.0
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode head = dummy;

        while (l1 != null || l2 != null) {

            if (l1 == null || ((l1 != null && l2 != null) && l1.val > l2.val)) {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
                head = head.next;
            } else if (l2 == null || ((l1 != null && l2 != null) && l1.val < l2.val)) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
                head = head.next;
                //与参考答案mergerTwoListsBeauty 比，这里没有走两步，而是交给下一次循环，反而代码比较简单，可以抽取通用逻辑
            } else if (l1 != null && l2 != null && l1.val == l2.val) {
                head.next = new ListNode(l2.val);
                head.next.next = new ListNode(l1.val);
                l2 = l2.next;
                l1 = l1.next;
                head = head.next.next;
            } else {
                return dummy.next;
            }
        }
        return dummy.next;
    }

    public ListNode mergerTwoListsBeauty(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;

        }

        prev.next = l1 == null ? l2 : l1;

        return preHead.next;

    }


    public ListNode mergeTwoListUsingRecursive(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListUsingRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListUsingRecursive(l1, l2.next);
            return l2;
        }

    }


    @Test
    public void testMergeTwoList() {


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        //预期结果 1->1->2->3-3->4

//        ListNode result = mergeTwoListUsingRecursive(l1, l2);
        ListNode result = mergerTwoListsBeauty(l1, l2);
//        ListNode result = mergeTwoLists(l1, l2);

        Assert.assertEquals(result.val, 1);
        Assert.assertEquals(result.next.val, 1);
        Assert.assertEquals(result.next.next.val, 2);
        Assert.assertEquals(result.next.next.next.val, 3);
        Assert.assertEquals(result.next.next.next.next.val, 3);
        Assert.assertEquals(result.next.next.next.next.next.val, 4);

    }

    @Test
    public void testMergeTwoList2() {


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);

        //预期结果 1->2->3->5

//        ListNode result = mergeTwoListUsingRecursive(l1, l2);
        ListNode result = mergerTwoListsBeauty(l1, l2);
//        ListNode result = mergeTwoLists(l1, l2);

        Assert.assertEquals(result.val, 1);
        Assert.assertEquals(result.next.val, 2);
        Assert.assertEquals(result.next.next.val, 3);
        Assert.assertEquals(result.next.next.next.val, 5);
    }


}
