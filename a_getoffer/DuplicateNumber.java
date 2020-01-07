package a_getoffer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * <p>
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * <p>
 * Output:
 * 2
 *
 * @author XiaoXiong
 * @since 2020-01-03
 */
public class DuplicateNumber {


    /*
    解题思路：
    如果不考虑时间,空间复杂度，一开始想到的Set即使用Hash表

    其余思路：
    - 先排序再判断相邻数是否相等
    - 使用数组下标存放于该下标相同值的数
     */


    public static int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            while (i != nums[i]) {

                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;

            }
        }


        return -1;

    }


    @Test
    public void test() {

        int[] test = {1, 2, 3, 1, 5, 7};


        Assert.assertEquals(1, findDuplicate(test));


    }


}
