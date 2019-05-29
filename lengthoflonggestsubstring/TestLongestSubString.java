package lengthoflonggestsubstring;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author XiaoXiong
 * @since 2019/5/28
 */
public class TestLongestSubString {

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

}
