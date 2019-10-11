package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author XiaoXiong
 * @since 2019-10-11
 * <p>
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {

    /**
     * 暴力法
     * 时间复杂度 O(n^2)
     *
     * @param nums
     * @return
     */
    public int maxAreaUserBruteForce(int[] nums) {

        if (nums.length < 2) {
            throw new IllegalArgumentException("数组长度应该不小于2");
        }
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int area = Math.min(nums[i], nums[j]) * (j - i);
                res = Math.max(area, res);
            }
        }

        return res;
    }


    /**
     * 双指针法
     * 时间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public int maxAreaUserTwinPointer(int[] nums) {
        int i = 0, j = nums.length - 1;
        int res = 0;
        while (i < j) {
            int area = (j - i) * Math.min(nums[i], nums[j]);
            res = Math.max(area, res);

            if (nums[i] > nums[j]) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }


    @Test
    public void testMaxAreaUserBruteForce() {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        Assert.assertEquals(49, maxAreaUserBruteForce(nums));
    }


    @Test
    public void testMaxAreaUserTwinPointer() {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        Assert.assertEquals(49, maxAreaUserTwinPointer(nums));
    }

}
