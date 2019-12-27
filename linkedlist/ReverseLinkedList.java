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


    /**
     * 递归解法
     */
    public static ListNode reserveListWithRecursive(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;


    }


    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(1);

//        ListNode result = reverseList(l1);
        ListNode result = reserveListWithRecursive(l1);

        Assert.assertEquals(l2.val, result.val);
        Assert.assertEquals(l2.next.val, result.next.val);
        Assert.assertEquals(l2.next.next.val, result.next.next.val);


    }


}
