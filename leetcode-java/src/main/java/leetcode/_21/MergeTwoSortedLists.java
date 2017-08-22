package leetcode._21;

import leetcode.base.ListNode;

/**
 * 这里其实是原地把l1和l2都改了的，如果要求不改动l1和l2，请勿这么做，需要new一个ListNode
 * 这么做，主要是速度快
 *
 * @author wenqi.wei created on 2017/7/28
 * @version 1.0
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode another = l1.val < l2.val ? l2 : l1;
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode tmp;
            if (cur.next.val > another.val) {
                tmp = cur.next;
                cur.next = another;
                another = tmp;
            }
            cur = cur.next;
        }
        cur.next = another;
        return head;
    }
}
