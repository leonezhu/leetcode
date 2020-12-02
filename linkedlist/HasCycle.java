package linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author XiaoXiong
 * @since 2020/3/30
 */
public class HasCycle {


    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new LinkedHashSet<>();

        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            } else {
                nodes.add(head);
            }
            head = head.next;
        }
        return false;
    }




    /**
     * 1.
     */
    @Test
    public void test() {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        Assert.assertFalse(hasCycle(l1));


        l3.next = l2;
        Assert.assertTrue(hasCycle(l1));

    }
}
