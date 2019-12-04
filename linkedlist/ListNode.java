package linkedlist;

/**
 * singly-linked
 *
 * @author XiaoXiong
 * @since 2019-11-14
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
