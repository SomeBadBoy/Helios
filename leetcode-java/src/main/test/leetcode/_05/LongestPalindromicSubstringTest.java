package leetcode._05;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenqi.wei created on 16/11/27
 * @version 1.0
 */
public class LongestPalindromicSubstringTest {

    @Test
    public void testLongestPalindrome() throws Exception {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("aaa"));
        System.out.println(test.longestPalindrome("bbbb"));
        System.out.println(test.longestPalindrome("ababa"));
        System.out.println(test.longestPalindrome("hhabab"));
        System.out.println(test.longestPalindrome("abb"));
    }
}