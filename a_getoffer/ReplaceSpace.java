package a_getoffer;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423
 *
 * @author XiaoXiong
 * @since 2020-01-07
 */
public class ReplaceSpace {


    public static String replaceSpace(StringBuffer str) {
        //方法一：直接用replace方法替换

//        return str.toString().replace(" ", "%20");

        //方法二：新建一个字符串

        //方法三：在当前字符串上替换
        //TODO

        return null;



    }


    @Test
    public void test() {

        StringBuffer str = new StringBuffer("I Love China");

        String expertResult = "I%20Love%20China";

        Assert.assertEquals(expertResult, replaceSpace(str));
    }


}
