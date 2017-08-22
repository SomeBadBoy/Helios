package leetcode._04;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenqi.wei created on 2017/8/1
 * @version 1.0
 */
public class MedianOfTwoSortedArrayTest {
    MedianOfTwoSortedArray solution = new MedianOfTwoSortedArray();
    @Test
    public void findMedianSortedArrays() throws Exception {
    }

    @Test
    public void findNearBy() throws Exception {
        System.out.println(solution.findNearBy(new int[]{1, 2, 4, 5}, 0, 4, 3));
        System.out.println(solution.findNearBy(new int[]{1, 3, 4, 5}, 0, 4, 3));
    }

}