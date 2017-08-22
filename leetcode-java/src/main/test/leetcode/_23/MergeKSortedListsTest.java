package leetcode._23;

import leetcode.base.ListNode;
import org.junit.Test;

/**
 * @author wenqi.wei created on 2017/7/31
 * @version 1.0
 */
public class MergeKSortedListsTest {
    @Test
    public void mergeKLists() throws Exception {
        MergeKSortedLists solution = new MergeKSortedLists();
        System.out.println(solution.mergeKLists(new ListNode[]{
//                new ListNode(new int[]{0, 2, 3, 4}),
                new ListNode(new int[]{1}),
//                new ListNode(new int[]{5, 10}),
                null
        }));
    }

    @Test
    public void testHeap() throws Exception {
        ListNode[] data = new ListNode[]{
                new ListNode(new int[]{0, 2, 4}),
                new ListNode(new int[]{1, 3, 5}),
                new ListNode(new int[]{5, 3, 5}),
                new ListNode(new int[]{4, 3, 5}),
                new ListNode(new int[]{2, 3, 5}),
        };
        MergeKSortedLists.ListNodeHeap heap = new MergeKSortedLists.ListNodeHeap(data);
        System.out.println(heap);
    }

}