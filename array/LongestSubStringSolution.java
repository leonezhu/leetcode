package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/*
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 */

/**
 * @author XiaoXiong
 * @since 2019/5/28
 */
public class LongestSubStringSolution {

    //暴力解法
    public static int getLongestSubString(String originStr) {
        int runTimes = 0;

        char[] chars = originStr.toCharArray();
        int max = 0;
        List<Character> container = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            container.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                runTimes++;
                if (container.contains(chars[j]) || container.size() + chars.length - j < max) {
                    max = container.size() > max ? container.size() : max;
                    System.out.println(container.toString());
                    container.clear();
                    break;
                }
                container.add(chars[j]);
            }
            max = container.size() > max ? container.size() : max;
            container.clear();
            continue;
        }
        System.out.println("runTimes =" + runTimes);
        return max;
    }


    //滑动窗口
    public static int method2(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();

        // ans=最长的长度 i=窗口左边下标  j=窗口右边下标
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++)); // 需要从头往后遍历
            }
        }
        return ans;
    }

    //

    /**
     * 滑动窗口优化
     * test string : abccdce
     * 当j=4时，current char = c ，map中存在，此时i需要跳转至j+1即d处开始
     *
     * @param s
     * @return
     */
    public static int method3(String s) {
        int n = s.length(), ans = 0;
        //key=不重复的字符  value=当key重复时i需要跳转的index 即j+1
        Map<Character, Integer> map = new HashMap<>(n);
        for (int j = 0, i = 0; j < n; j++) {

            if (map.containsKey(s.charAt(j))) {
                int index = map.get(s.charAt(j));
                i = Math.max(index, i); //直接跳到不重复那个字符所在的index

            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }


        return ans;
    }


    /**
     * 参考答案的暴力写法
     * public static int getLongestSubString(String originStr) {
     * int max = 0;
     * List<Character> container = new ArrayList<>();
     * for (int i = 0; i < originStr.length(); i++) {
     * for (int j = i + 1; j < originStr.length(); j++) {
     * if (allUnique(originStr, i, j)) {
     * max = Math.max(max, j - i);
     * }
     * }
     * }
     * return max;
     * }
     * <p>
     * public static boolean allUnique(String s, int start, int end) {
     * Set<Character> set = new HashSet<>();
     * char[] chars = s.toCharArray();
     * for (int i = start; i < end; i++) {`
     * if (set.contains(chars[i])) {
     * return false;
     * }
     * set.add(chars[i]);
     * }
     * return true;
     * }
     */


    private String testStr = "abccdce";
    private String testStr2 = "abcadcefdefabdcdcs";


    @Test
    public void testLongestSubStr() {

        System.out.println("testStr=" + testStr);
        Assert.assertEquals(3, LongestSubStringSolution.getLongestSubString(testStr)); //runTimes =11

        System.out.println("testStr=" + testStr2);
        Assert.assertEquals(6, LongestSubStringSolution.getLongestSubString(testStr2)); //runTimes =56
    }

    @Test
    public void testMethod2() {

        System.out.println("testStr=" + testStr);
        Assert.assertEquals(3, LongestSubStringSolution.method2(testStr)); //  runTimes =11

        System.out.println("testStr=" + testStr2);
        Assert.assertEquals(6, LongestSubStringSolution.method2(testStr2)); //  runTimes =33


    }

    @Test
    public void testMethod3() {

        System.out.println("testStr=" + testStr);
        Assert.assertEquals(3, LongestSubStringSolution.method3(testStr));

        System.out.println("testStr=" + testStr2);
        Assert.assertEquals(6, LongestSubStringSolution.method3(testStr2));



    }
}
