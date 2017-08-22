package leetcode._23;

import leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 用一个最小堆维护K个list，每次出队一个list中的一个node
 * 遗憾的是，自己实现的最小堆性能上有欠缺，使用了{@link PriorityQueue} 来做的
 *
 * @author wenqi.wei created on 2017/7/30
 * @version 1.0
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0), curNode = head;
        if (lists.length <= 0) return head.next;
        if (lists.length == 1) return lists[0];
//        ListNodeHeap heap = new ListNodeHeap(lists);
//        ListNode pop = heap.pop();
//        while (pop != null) {
//            curNode.next = pop;
//            curNode = curNode.next;
//            pop = heap.pop();
//        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1 == null ? 1 : o2 == null ? -1 : o1.val - o2.val);
        queue.addAll(Arrays.stream(lists).filter(Objects::nonNull).collect(Collectors.toList()));
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            if (poll != null && poll.next != null) {
                queue.offer(poll.next);
            }
            curNode.next = poll;
            curNode = curNode.next;
        }
        return head.next;
    }

    public static class ListNodeHeap {
        List<ListNode> data = new ArrayList<>(16);
        int size = 0;

        public ListNodeHeap(ListNode[] data) {
            this.data = Arrays.asList(data);
            this.size = this.data.size();
            compact();
            adjust();
        }

        public ListNodeHeap add(ListNode one) {
            data.add(one);
            size++;
            adjust();
            return this;
        }

        public ListNode pop() {
            if (size <= 0) return null;
            ListNode node = data.get(0);
            if (node != null) {
                if (node.next == null && size > 0) {
                    data.set(0, data.get(size - 1));
                    size--;
                } else {
                    data.set(0, node.next);
                }
                adjust();
            }
            return node;
        }

        private void nullRemove() {
            while (size > 0 && data.get(size - 1) == null)
                size--;
        }

        private void compact() {
            nullRemove();
            for (int i = 0; i < size; i++) {
                if (data.get(i) == null) {
                    data.set(i, data.get(size - 1));
                    size--;
                }
            }
        }

        private void adjust() {
            nullRemove();
            if (size <= 1)
                return;
            for (int i = (size >>> 1) - 1; i >= 0; i--) {
                adjustMore(i);
            }
        }

        private void adjustMore(int parent) {
            if (parent >= size) return;
            ListNode parentNode = data.get(parent);
            int left = (parent << 1) + 1;
            int right = left + 1;
            ListNode ln = left >= size ? null : data.get(left);
            ListNode rn = right >= size ? null : data.get(right);
            if (ln == null && rn == null) return;
            int index = ln == null ? right : rn == null ? left : ln.val > rn.val ? right : left;
            ListNode smaller = data.get(index);
            if (parentNode.val > smaller.val) {
                swapAndAdjust(parent, index);
            }
        }

        private void swapAndAdjust(int parent, int child) {
            if (parent >= size || child >= size) return;
            ListNode pn = data.get(parent);
            data.set(parent, data.get(child));
            data.set(child, pn);
            adjustMore(child);
        }

        @Override
        public String toString() {
            return "ListNodeHeap{" +
                    "data=" + data +
                    ", size=" + size +
                    '}';
        }
    }
}
