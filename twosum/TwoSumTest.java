package twosum;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author XiaoXiong
 * @since 2019/5/27
 */
public class TwoSumTest {

    TwoSum twoSum;

    public TwoSumTest() {
        this.twoSum = new TwoSum();
    }

    @Test
    public void testTwoSum() {
        int[] test = {3, 5, 5, 7, 2};
        int[] test1 = {2, 5, 6, 7, 7};
        Assert.assertArrayEquals(new int[]{3, 4}, twoSum.twoSum(test, 9));
        Assert.assertArrayEquals(new int[]{0, 3}, twoSum.twoSum(test1, 9));
    }

    @Test
    public void testTwoSumWithHash() {

        int[] test = {3, 5, 5, 7, 2};
        int[] test1 = {2, 5, 6, 7, 7};
        Assert.assertArrayEquals(new int[]{3, 4}, twoSum.twoSumWithHash(test, 9));
        Assert.assertArrayEquals(new int[]{0, 3}, twoSum.twoSumWithHash(test1, 9));
    }
}
