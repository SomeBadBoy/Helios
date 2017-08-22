package leetcode._18;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 与3Sum类似的解法
 * 有一个取巧的解法是，两两相加，转化为2sum，然后进行处理
 *
 * @author wenqi.wei created on 2017/7/28
 * @version 1.0
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length <= 1) return Collections.emptyList();
        Arrays.sort(nums);
        return kSum(nums, target, 0, nums.length, 4, null);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int end, int k, Consumer<List<Integer>> consumer) {
        List<List<Integer>> sum = new LinkedList<>();
        int max = nums[end - 1];
        for (int i = start; i < end; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            if (nums[i] + max * (k - 1) < target) continue;
            if (max < target && target > 0) break;
            if (nums[i] > target && target >= 0) break;
            final int fi = i;
            if (k > 1) {
                sum.addAll(kSum(nums, target - nums[i], i + 1, end, k - 1, (m) -> m.add(nums[fi])));
            } else if (nums[i] == target){
                List<Integer> tmp = new LinkedList<>();
                tmp.add(nums[i]);
                sum.add(tmp);
            }
        }
        if (consumer != null) {
            sum.forEach(consumer);
        }
        return sum;
    }

    /*
    用map的方式不太搞的定，先放着吧
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int sum = nums[i] + nums[j];
                List<Integer> tmp = new LinkedList<>();
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                if (!map.containsKey(sum)) {
                    List<List<Integer>> val = new LinkedList<>();
                    val.add(tmp);
                    map.put(sum, val);
                } else {
                    map.get(sum).add(tmp);
                }
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for (Integer integer : map.keySet()) {
            List<List<Integer>> lists = map.get(integer);
            if (map.containsKey(target - integer)) {
                List<List<Integer>> other = map.get(target - integer);
                if (target - integer != integer) {
                    for (List<Integer> one : lists) {
                        for (List<Integer> another : other) {
                            if (one.get(1) > another.get(0)) continue;
                            List<Integer> tmp = new LinkedList<>();
                            tmp.addAll(one);
                            tmp.addAll(another);
                            res.add(tmp);
                        }
                    }
                } else {
                    for (int i = 0; i < other.size(); i++) {
                        for (int j = i + 1; j < other.size(); j++) {
                            List<Integer> one = other.get(i);
                            List<Integer> another = other.get(j);
                            if (one.get(1) > another.get(0)) continue;
                            List<Integer> tmp = new LinkedList<>();
                            tmp.addAll(one);
                            tmp.addAll(another);
                            res.add(tmp);
                        }
                    }
                }
            }
        }
        return res;
    }*/
}
