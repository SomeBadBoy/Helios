package leetcode._16;

import java.util.Arrays;

/**
 * 从数组中，找到三个数，使得三数之和最接近target，只有一组这样的数，输出最后的结果
 * <p>
 * 首先的思路，就是对每一个数，简化为two sum，但是这样，其实是O(n*n)的时间复杂度，所以上网查了一下
 * 发现这个基本就是下界了，所以
 *
 * @author wenqi.wei created on 2017/7/16
 * @version 1.0
 */
public class _3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int sum = find2Sum(nums, target, i);
            closest = Math.abs(sum - target) > Math.abs(closest - target) ? closest : sum;
        }
        return closest;
    }

    protected int find2Sum(int[] nums, int target, int start) {
        int head = start + 1, tail = nums.length - 1;
        int closest = nums[head] + nums[tail] + nums[start];
        while (head < tail) {
            int sum = nums[head] + nums[tail] + nums[start];
            if (sum == target) {
                return sum;
            } else if (sum > target) {
                tail--;
                if (sum - target < Math.abs(closest - target)) {
                    closest = sum;
                }
            } else {
                head++;
                if (target - sum < Math.abs(closest - target)) {
                    closest = sum;
                }
            }
        }
        return closest;
    }
}
