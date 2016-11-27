package leetcode._06;

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
        System.out.println(test.convert("PAYPALISHIRING", 3));
    }
}