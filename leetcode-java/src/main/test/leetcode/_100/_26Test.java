package leetcode._100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wenqi.wei created on 2017/8/18
 * @version 1.0
 */
public class _26Test {
    @Test
    public void removeDuplicates() throws Exception {
        _26 solution = new _26();
        int[] nums = {1, 1, 1, 2, 3,3,3,4,4,5,5,5,5};
        System.out.println(solution.removeDuplicates(nums) + ":" + Arrays.toString(nums));
    }

    @Test
    public void move() throws Exception {
    }

}