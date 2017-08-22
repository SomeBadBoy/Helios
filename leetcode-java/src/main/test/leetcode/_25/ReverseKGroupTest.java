package leetcode._25;

import leetcode.base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenqi.wei created on 2017/7/31
 * @version 1.0
 */
public class ReverseKGroupTest {
    @Test
    public void reverseKGroup() throws Exception {
        ReverseKGroup solution = new ReverseKGroup();
        System.out.println(solution.reverseKGroup(new ListNode(new int[]{1,2,3,4,5}), 2));
        System.out.println(solution.reverseKGroup(new ListNode(new int[]{1,2,3,4}), 2));
        System.out.println(solution.reverseKGroup(new ListNode(new int[]{1,2,3,4,5}), 3));
        System.out.println(solution.reverseKGroup(new ListNode(new int[]{1,2,3,4}), 5));
    }

}