package leetcode._24;

import leetcode.base.ListNode;

/**
 * 非常简单，不做详细说明了
 *
 * @author wenqi.wei created on 2017/7/31
 * @version 1.0
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode current = head;
        ListNode tmp, prev = null;
        while (current != null && current.next != null) {
            tmp = current.next;
            current.next = tmp.next;
            tmp.next = current;
            if (prev != null) {
                prev.next = tmp;
            }
            prev = current;
            current = current.next;
        }
        return newHead;
    }
}
