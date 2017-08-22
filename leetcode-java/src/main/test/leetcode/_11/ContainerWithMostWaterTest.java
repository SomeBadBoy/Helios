package leetcode._11;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenqi.wei created on 2017/7/15
 * @version 1.0
 */
public class ContainerWithMostWaterTest {
    @Test
    public void maxArea() throws Exception {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        Assert.assertEquals(6, solution.maxArea(new int[]{1, 2, 3, 4, 5}));
    }

}