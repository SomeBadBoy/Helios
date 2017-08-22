package leetcode._19;

/**
 * @author wenqi.wei created on 2017/7/26
 * @version 1.0
 */
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int prev = 0;
        ListNode node = head;
        ListNode target = null;
        while (node != null) {
            node = node.next;
            if (target != null) {
                target = target.next;
            }
            if (prev++ == n) {
                target = head;
            }
        }
        if (prev == n) {
            target = head.next;
        } else if (target != null && target.next != null) {
            target.next = target.next.next;
            target = head;
        }
        return target;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
