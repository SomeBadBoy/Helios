package leetcode._04;

/**
 * @author wenqi.wei created on 16/11/27
 * @version 1.0
 */
public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] first, int[] second) {
        if (first.length <= 0 && second.length <= 0) {
            return 0;
        }
        int idf = 0, ids = 0, idx = 0;
        int mid = (first.length + second.length - 1) >> 1;
        int _mid = mid;
        if (((first.length + second.length) & 1) == 0) {
            ++_mid;
        }
        double median = 0;
        int pop = 0;
        while (true) {
            if (idf >= first.length) {
                pop = second[ids++];
            } else if (ids >= second.length) {
                pop = first[idf++];
            } else if (first[idf] >= second[ids]) {
                pop = second[ids++];
            } else {
                pop = first[idf++];
            }
            if (idx == mid) {
                median += pop;
            } else if (idx == _mid) {
                median += pop;
            }
            ++idx;
            if (idx > _mid) {
                break;
            }
        }
        if (_mid == 0) {
            return first.length > 0 ? (double) first[0] : (double) second[0];
        }
        if (_mid == mid) {
            return median;
        }
        return median / 2.0;
    }
}
