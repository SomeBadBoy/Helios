package leetcode._07;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenqi.wei created on 16/11/28
 * @version 1.0
 */
public class ReverseIntegerTest {

    // -2147483648 Integer.MIN_VALUE
    // 2147483647 Integer.MAX_VALUE
    @Test
    public void testReverse() throws Exception {
        ReverseInteger test = new ReverseInteger();
        Assert.assertEquals(0, test.reverse(-2147483648));
        Assert.assertEquals(321, test.reverse(123));
        Assert.assertEquals(-321, test.reverse(-123));
        Assert.assertEquals(-321, test.reverse(-123000));
        Assert.assertEquals(2147483641, test.reverse(1463847412));
        Assert.assertEquals(0, test.reverse(1563847412));
    }
}