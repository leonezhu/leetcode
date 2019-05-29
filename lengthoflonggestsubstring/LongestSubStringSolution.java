package lengthoflonggestsubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoXiong
 * @since 2019/5/28
 */
public class LongestSubStringSolution {

    public static int getLongestSubString(String originStr) {
        int calcSize = 0;

        char[] chars = originStr.toCharArray();
        int max = 0;
        List<Character> container = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            container.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                calcSize++;
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
        System.out.println("calcSize =" + calcSize);
        return max;
    }

    /**
     *     public static int getLongestSubString(String originStr) {
     *         int max = 0;
     *         List<Character> container = new ArrayList<>();
     *         for (int i = 0; i < originStr.length(); i++) {
     *             for (int j = i + 1; j < originStr.length(); j++) {
     *                 if (allUnique(originStr, i, j)) {
     *                     max = Math.max(max, j - i);
     *                 }
     *             }
     *         }
     *         return max;
     *     }
     *
     *     public static boolean allUnique(String s, int start, int end) {
     *         Set<Character> set = new HashSet<>();
     *         char[] chars = s.toCharArray();
     *         for (int i = start; i < end; i++) {
     *             if (set.contains(chars[i])) {
     *                 return false;
     *             }
     *             set.add(chars[i]);
     *         }
     *         return true;
     *     }
     */
}

