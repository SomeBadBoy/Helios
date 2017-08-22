package leetcode._100;

/**
 * 从一个有序数组中，remove掉重复的数字，返回最终得到的数组长度，同时，这个长度表明了nums数组中的前n个就是无重复并且有序的
 *
 * @author wenqi.wei created on 2017/8/17
 * @version 1.0
 */
public class _26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int length = 0, size = nums.length;
        for (int i = 0; i < size; i++) {
            boolean duplicated = false;
            int current = i;
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                duplicated = true;
                i++;
            }
            if (duplicated) {
                size = move(nums, current, i - current);
            }
            length++;
        }
        return length;
    }

    int move(int[] nums, int start, int k) {
        if (start >= nums.length || k >= nums.length) return -1;
        for (int i = start; i < start + k && i + k < nums.length; i++) {
            nums[i] = nums[i + k];
        }
        return nums.length - k;
    }
}
