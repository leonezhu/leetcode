package linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author XiaoXiong
 * @since 2019-10-10
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode ln1, ListNode ln2) {

        //哑结点
        //哑结点其实就是放在第一个存放数据结点之前、头结点之后的结点。
        //加入哑结点之后就可以使所有数据结点都有前驱结点，这样就会方便执行链表的一些操作。
        ListNode dummyHead = new ListNode(0);


        //p q 初始化为ln1 ln2 的头部
        ListNode p = ln1, q = ln2, curr = dummyHead;

        //进位
        int carry = 0;

        while (p != null || q != null) {

            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;

            int sum = x + y + carry;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);

            curr = curr.next;


            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }

        }

        //全部加完之后还有进位
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }


    @Test
    public void testAddTwoNumbers() {

        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);

        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);


        ListNode result = addTwoNumbers(l1, l2);

        Assert.assertEquals(result.val, 0);
        Assert.assertEquals(result.next.val, 2);
        Assert.assertEquals(result.next.next.val, 2);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
