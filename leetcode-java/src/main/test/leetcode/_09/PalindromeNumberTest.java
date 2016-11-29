package leetcode._09;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenqi.wei created on 16/11/28
 * @version 1.0
 */
public class PalindromeNumberTest {

    @Test
    public void testIsPalindrome() throws Exception {
        PalindromeNumber test = new PalindromeNumber();
        Assert.assertTrue(test.isPalindrome(1111));
        Assert.assertTrue(test.isPalindrome(12321));
        Assert.assertTrue(test.isPalindrome(5));
        Assert.assertTrue(test.isPalindrome(11));
        Assert.assertTrue(test.isPalindrome(2222222));
        Assert.assertTrue(test.isPalindrome(1000000001));
    }
}