package leetcode._11;

/**
 * 理解一下题目，就是一道动态规划，求一个正整数序列 1...n中两个数k,m，以及它们的距离l
 * 使得，min(k,m)*l最大
 * <p>
 * f(k-1).h = max {
 * f(k).h; if n(k-1) < min {n(m), n(k)}
 * min{n(k-1), n(m)} * l; otherwise
 * }
 *
 * @author wenqi.wei created on 2017/7/8
 * @version 1.0
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    /*
    这是一个正确的答案，但是性能太差了
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (i > 0 && height[i] < height[i - 1]) {
                continue;
            }
            for (int j = height.length - 1; j >= 0; --j) {
                if (j < height.length - 1 && height[j] < height[j + 1]) {
                    continue;
                }
                max = Math.max(Math.min(height[j], height[i]) * (j - i), max);
                //System.out.printf("maxWater[%d][%d] = %d\n", i, j, maxWaters[i][j]);
            }
        }
        return max;
    }
    */
}
