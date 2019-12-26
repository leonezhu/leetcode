package linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * /intersection-of-two-linked-lists
 *
 * @author XiaoXiong
 * @since 2019-12-26
 */
public class IntersectionOfTwoLinkedLists {


    /**
     * 双指针法
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode l1 = headA, l2 = headB;

        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }

        return l1;

    }


    @Test
    public void test() {

        //相交节点
        ListNode intersectionNode = new ListNode(5);
        intersectionNode.next = new ListNode(3);

        ListNode headA = new ListNode(2);
        headA.next = intersectionNode;


        ListNode headB = new ListNode(1);
        headB.next = new ListNode(4);
        headB.next.next = intersectionNode;


        ListNode result = IntersectionOfTwoLinkedLists.getIntersectionNode(headA, headB);

        Assert.assertEquals(intersectionNode, result);

    }


    /**
     * 不相交
     */
    @Test
    public void test2() {


        ListNode headA = new ListNode(2);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(4);


        ListNode headB = new ListNode(1);
        headB.next = new ListNode(5);


        ListNode result = IntersectionOfTwoLinkedLists.getIntersectionNode(headA, headB);

        Assert.assertNull(result);

    }

}
