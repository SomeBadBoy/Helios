package leetcode.base;

/**
 * @author wenqi.wei created on 2017/7/28
 * @version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] x) {
        assert x != null;
        assert x.length > 0;

        this.val = x[0];
        if (x.length > 1) {
            ListNode head = this;
            for (int i = 1; i < x.length; i++) {
                head.next = new ListNode(x[i]);
                head = head.next;
            }
        }
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }
}
