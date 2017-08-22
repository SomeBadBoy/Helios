package leetcode._15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wenqi.wei created on 2017/7/16
 * @version 1.0
 */
public class _3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sum = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            sum.addAll(find2Sum(nums, 0 - nums[i], i));
        }
        return sum;
    }

    protected List<List<Integer>> find2Sum(int[] nums, int target, int start) {
        int head = start + 1, tail = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (head < tail) {
            if (nums[head] + nums[tail] == target) {
                ArrayList<Integer> res = new ArrayList<Integer>();
                res.add(nums[head]);
                res.add(nums[tail]);
                res.add(nums[start]);
                result.add(res);
                while (head < tail && nums[head] == nums[head + 1]) {
                    head++;
                }
                while (head < tail && nums[tail] == nums[tail - 1]) {
                    tail--;
                }
                head++;
                tail--;
            } else if (nums[head] + nums[tail] > target) {
                tail--;
            } else {
                head++;
            }
        }
        return result;
    }
}
