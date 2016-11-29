package leetcode._06;

import java.text.MessageFormat;

/**
 * @author wenqi.wei created on 16/11/27
 * @version 1.0
 */
public class ZigZagConversion {
    String format = "第{0}组第{1}个的序号为{2}, 展示位置为{3}";

    /**
     * like this
     * <p>
     * A       I       Q
     * B     H J     P R
     * C   G   K   O   S
     * D F     L N     T
     * E       M       U
     */
    public String convert(String s, int numRows) {
        if (s == null || s.equals("") || numRows <= 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        int idx = 0;
        boolean backward = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            System.out.println(i + ":" + pos + ":" + idx);
            if (sbs[idx] == null) {
                sbs[idx] = new StringBuilder();
            }
            sbs[idx].append(c);
            if (idx == numRows - 1) {
                backward = true;
            } else if (idx == 0) {
                backward = false;
            }
            if (backward) {
                idx--;
            } else {
                idx++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sbs.length; i++) {
//            System.out.println(i + ":" + sbs[i]);
            if (sbs[i] != null && sbs[i].length() > 0) {
                res.append(sbs[i]);
            }
        }
        return res.toString();
    }

    public String convert_v2(String s, int numRows) {
        if (s == null || s.equals("") || numRows <= 1) {
            return s;
        }
        // 两列之和
        int num = numRows + numRows / 2;
        // 总共有多少这样的两列
        int per = (s.length() + num - 1) / num;
        int len = s.length();
        int[] codes = new int[per * numRows * 2];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < per; j++) {
                int index = 0;
                // 前几列的字符总数
                index += j * per;
                index += i;
                int k = 0;
                // 当前行的上几行的总和
                k += i / 2 * per * 2 + ((i + 1) / 2) * per;
                // 当前行的左几列的总和
                k += (i & 1) == 1 ? j : 2 * j;
                System.out.println(MessageFormat.format(format, j, i, index, k));
                if (index < len) {
                    codes[k] = s.charAt(index);
                }

            }
        }
        int[] chars = new int[s.length()];
        int idx = 0;
        for (int code : codes) {
            if (code <= 90 && code >= 65) {
                chars[idx++] = code;
            }
        }
        return new String(chars, 0, chars.length);
    }
}
