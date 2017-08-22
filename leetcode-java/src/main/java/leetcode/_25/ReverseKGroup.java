package leetcode._25;

import leetcode.base.ListNode;

/**
 * @author wenqi.wei created on 2017/7/31
 * @version 1.0
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null)
            return head;
        ListNode root = new ListNode(0), cur = head, prev = root;
        root.next = head;
        int count = 1;
        while (cur != null) {
            cur = cur.next;
            if (++count == k) {
                count = 1;
                prev = reverse(prev, cur);
                cur = prev == null ? null : prev.next;
            }
        }
        return root.next;
    }

    ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || tail == null || head.next == null) return null;
        ListNode cur = head.next, prev = tail.next, post = cur.next, next = head.next;
        while (cur != null && prev != tail) {
            cur.next = prev;
            prev = cur;
            cur = post;
            post = post == null ? null : post.next;
        }
        head.next = prev;
        return next;
    }
}
