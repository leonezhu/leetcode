package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaoXiong
 * @since 2019/5/27
 * <p>
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public int[] twoSumWithHashTwoPass(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }


        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement) && map.get(complement) != i) {

                //map里先有数据  所以i得放在前面
//                return new int[]{map.get(complement), i};
                return new int[]{i, map.get(complement)};

            }

            map.put(nums[i], i);
        }


        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * @param nums
     * @param target 两数和的目标值
     * @return
     */
    public int[] twoSumWithHash(int[] nums, int target) {


        /*
         {3, 5, 5, 7, 2}     9

         1:  {3,0}
         2:  {5,1}
         3:  {5,2}
         4:  {7,3}
         5:  {2,4}   9-2 =7  map中有key=7的值 返回结果 [3,4]

         */


        // key：值   value：下标
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 测试数组里的数据不能重复
     */
    private int[] test = {3, 5, 8, 7, 2};

    private int[] test1 = {2, 5, 6, 7, 8};

    @Test
    public void testTwoSum() {
        Assert.assertArrayEquals(new int[]{3, 4}, this.twoSum(test, 9));
        Assert.assertArrayEquals(new int[]{0, 3}, this.twoSum(test1, 9));
    }

    @Test
    public void twoSumWithHashTwoPass() {
        Assert.assertArrayEquals(new int[]{3, 4}, this.twoSumWithHashTwoPass(test, 9));
        Assert.assertArrayEquals(new int[]{0, 3}, this.twoSumWithHashTwoPass(test1, 9));
    }

    @Test
    public void testTwoSumWithHash() {
        Assert.assertArrayEquals(new int[]{3, 4}, this.twoSumWithHash(test, 9));
        Assert.assertArrayEquals(new int[]{0, 3}, this.twoSumWithHash(test1, 9));
    }

}
