package leetcode._12;

/**
 * 罗马数字：
 * Ⅰ(1)、X(10)、C(100)、M(1000)、V(5)、L(50)、D(500)
 * <p>
 * 其中ICX可以放在一个大数的左边，表示减，最多放一个
 * 其他的放大数右边，表示加，最多放三个
 * <p>
 * 解决思路呢，就是用贪心，从高位开始，选用最大的roman number
 *
 * 当然，另外一个解决办法，就是做一个表，每一位都查表就可以了
 *
 * @author wenqi.wei created on 2017/7/15
 * @version 1.0
 */
public class Integer2Roman {
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        String[][] table = new String[][] {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        roman.append(table[3][num / 1000 % 10]);
        roman.append(table[2][num / 100 % 10]);
        roman.append(table[1][num / 10 % 10]);
        roman.append(table[0][num % 10]);
        return roman.toString();
    }
}
