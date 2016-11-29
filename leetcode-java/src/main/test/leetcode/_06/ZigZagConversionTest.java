package leetcode._06;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenqi.wei created on 16/11/27
 * @version 1.0
 */
public class ZigZagConversionTest {

    @Test
    public void testConvert() throws Exception {
        ZigZagConversion test = new ZigZagConversion();
        Assert.assertEquals("PAHNAPLSIIGYIR", test.convert("PAYPALISHIRING", 3));
        Assert.assertEquals("ACB", test.convert("ABC", 2));
        Assert.assertEquals("ABCED", test.convert("ABCDE", 4));
    }

    @Test
    public void testMain() {
        System.out.println(Integer.MIN_VALUE);
    }
}