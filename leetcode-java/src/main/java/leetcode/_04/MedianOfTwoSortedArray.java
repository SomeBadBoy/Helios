package leetcode._04;

/**
 * @author wenqi.wei created on 16/11/27
 * @version 1.0
 */
public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] first, int[] second) {
        if (first.length <= 0 && second.length <= 0) return 0;
        if (first.length <= 0 || second.length <= 0) {
            int[] target = first.length <= 0 ? second : first;
            return (target.length & 1) == 0 ? target[target.length >> 1] : (target[target.length >> 1] + target[(target.length >> 1) + 1]) / 2;
        }
        return 0;
    }

    /**
     * 找到数组中小于target的元素的位置，如果没有小于target的元素，返回-1
     * 如果数组中恰好有多个元素与target相等，则返回下标最大的一个
     */
    int findNearBy(int[] arr, int start, int end, int target) {
        if (start >= end || start >= arr.length || end > arr.length)
            throw new IllegalArgumentException(String.format("Out of bounds with [%s] and [%s]", start, end));
        if (start + 1 == end)
            return arr[start] > target ? -1 : start;
        int mid = start;
        while (start <= end) {
            mid = (start + end + 1) >> 1;
            if (arr[mid] == target) {
                while (mid < end && arr[mid] == target) mid++;
                return mid - 1;
            }
            if (arr[mid] < target) {
                if (start == mid) {
                    return mid;
                }
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return mid;
    }

    /*
    下面这个是正确解，但时间复杂度为O(m+n)，不满足题目要求，虽然能AC，但是走的野路子
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
    }*/
}
