package leetcode._02;

import leetcode.base.ListNode;

/**
 * @author wenqi.wei created on 16/11/26
 * @version 1.0
 */
public class AddTwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0), point = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = val / 10;
            val = val % 10;
            point.next = new ListNode(val);
            point = point.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }
}
