package leetcode._13;

/**
 * 罗马数字：
 * Ⅰ(1)、X(10)、C(100)、M(1000)、V(5)、L(50)、D(500)
 * <p>
 * 其中ICX可以放在一个大数的左边，表示减，最多放一个
 * 其他的放大数右边，表示加，最多放三个
 *
 * @author wenqi.wei created on 2017/7/15
 * @version 1.0
 */
public class Roman2Integer {

    public int romanToInt(String s) {
        int[] table = new int[128];
        table['M'] = 1000;
        table['C'] = 100;
        table['X'] = 10;
        table['I'] = 1;
        table['D'] = 500;
        table['L'] = 50;
        table['V'] = 5;
        int last = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            if (last > table[c] && (c == 'C' || c == 'X' || c == 'I')) {
                sum -= table[c];
            } else {
                sum += table[c];
            }
            last = table[c];
        }
        return sum;
    }
}
