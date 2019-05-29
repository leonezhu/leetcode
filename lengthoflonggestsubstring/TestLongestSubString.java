package lengthoflonggestsubstring;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author XiaoXiong
 * @since 2019/5/28
 */
public class TestLongestSubString {

    @Test
    public void testLongestSubStr() {

        String testStr = "abccdce";

        System.out.println("testStr=" + testStr);
        Assert.assertEquals(3, LongestSubStringSolution.getLongestSubString(testStr));

        String testStr2 = "abcadcefdefabdcdcs";
        System.out.println("----------------------------");
        System.out.println("testStr=" + testStr2);
        Assert.assertEquals(6, LongestSubStringSolution.getLongestSubString(testStr2));
    }

}
