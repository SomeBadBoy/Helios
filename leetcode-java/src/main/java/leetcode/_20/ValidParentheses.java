package leetcode._20;

import java.util.Stack;

/**
 * @author wenqi.wei created on 2017/7/28
 * @version 1.0
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (ch == ')' && pop != '(') return false;
                if (ch == ']' && pop != '[') return false;
                if (ch == '}' && pop != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
