package leetcode._01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wenqi.wei created on 16/11/26
 * @version 1.0
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        List<Holder> sorted = sort(nums);
        int[] result = new int[2];
        for (int i = 0, j = sorted.size() - 1; i < j && i < sorted.size() && j >= 0;) {
            int sum = sorted.get(i).data + sorted.get(j).data;
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else if (sum == target) {
                result[0] = sorted.get(i).data;
                result[1] = sorted.get(j).data;
                break;
            }
        }
        Collections.sort(sorted, (o1, o2) -> o1.index - o2.index);
        int[] index = new int[2];
        boolean first = true;
        for (int i = 0; i < nums.length; i++) {
            if (sorted.get(i).data == result[0] && first) {
                index[0] = i;
                first = false;
            }
            if (sorted.get(i).data == result[1]) {
                index[1] = i;
            }
        }
        return index;
    }

    private List<Holder> sort(int[] nums) {
        List<Holder> sorted = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            sorted.add(new Holder(nums[i], i));
        }
        Collections.sort(sorted);
        return sorted;
    }

    private class Holder implements Comparable<Holder> {
        public int data;
        public int index;

        public Holder(int data, int index) {
            this.data = data;
            this.index = index;
        }

        @Override
        public int compareTo(Holder that) {
            return this.data - that.data == 0 ? this.index - that.index : this.data - that.data;
        }
    }
}
