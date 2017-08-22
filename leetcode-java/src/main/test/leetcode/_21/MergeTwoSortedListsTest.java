package leetcode._21;

import leetcode.base.ListNode;
import org.junit.Test;

/**
 * @author wenqi.wei created on 2017/7/28
 * @version 1.0
 */
public class MergeTwoSortedListsTest {
    @Test
    public void mergeTwoLists() throws Exception {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        System.out.println(solution.mergeTwoLists(new ListNode(new int[]{-9, -7, -3, -3, -1, 2, 3}),
                new ListNode(new int[]{-7, -7, -6, -6, -5, -3, 2, 4})));

        System.out.println(solution.mergeTwoLists(new ListNode(new int[]{1, 2, 3, 4, 5, 12}),
                new ListNode(new int[]{6, 7, 8, 9, 10})));
    }

}