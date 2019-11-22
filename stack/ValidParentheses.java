package stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author XiaoXiong
 * @since 2019-11-22
 */
public class ValidParentheses {


    /**
     * 使用双指针法 只有对称情况才有效  String str = " ({[]}) ";
     * 第一次解，没有省清题，以为都是对称的
     * 还得用栈
     *
     * @param s
     * @return
     */
    public boolean errMethod(String s) {

        if (isUnLegalString(s)) {
            return false;
        }
        int startIndex = 0;
        int endIndex = s.length() - 1;

        while (startIndex < endIndex) {
            String startChar = s.substring(startIndex, startIndex + 1);
            String endChar = s.substring(endIndex, endIndex + 1);

            if (!match(startChar, endChar)) {
                return false;
            }

            startIndex++;

            endIndex--;

        }
        return true;
    }

    /**
     * 自己第一次正解
     *
     * @param s
     * @return
     */
    public boolean isValidUsingCustomStack(String s) {

        if (isUnLegalString(s)) {
            return false;
        }

        StringArrayStack stack = new StringArrayStack(s.length());

        for (char c : s.toCharArray()) {
            String popStr = stack.pop();
            if (popStr == null) {
                stack.push(c + "");
            } else {
                if (!match(popStr, c + "")) {
                    stack.push(popStr);
                    stack.push(c + "");
                }
            }
        }

        return stack.pop() == null;
    }

    /**
     * TODO 官方解法：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {


        return false;
    }


    private boolean match(String left, String right) {
        if (" ".equals(left) && " ".equals(right)) {
            return true;
        }
        if ("{".equals(left) && "}".equals(right)) {
            return true;
        }

        if ("[".equals(left) && "]".equals(right)) {
            return true;
        }

        if ("(".equals(left) && ")".equals(right)) {
            return true;
        }
        return false;

    }

    private boolean isUnLegalString(String s) {
        return (s == null || s.length() <= 0) || (s.length() % 2 != 0);
    }


    @Test
    public void validTestWhenStringIsNull() {
        String str = "";
//        String str = null;
        assertFalse(isValidUsingCustomStack(str));
    }


    @Test
    public void validTestWhenStringLengthIsOddNumber() {
        String str = "{}[";
        assertFalse(isValidUsingCustomStack(str));
    }


    @Test
    public void validTestWhenStringWasSymmetrical() {
        String str = " ({[]}) ";
        assertTrue(isValidUsingCustomStack(str));
    }

    @Test
    public void validTest() {
//        String str = "  {}[]()  ";
        String str = "((()(())))";
        assertTrue(isValidUsingCustomStack(str));
    }

}
