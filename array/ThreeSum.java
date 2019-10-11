package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XiaoXiong
 * @since 2019-10-11
 * https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 */
public class ThreeSum {

    /**
     * 排序+ 双指针
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

//        if (nums == null || nums.length < 3) {
//            throw new IllegalArgumentException("数组长度不能小于3");
//        }

        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            //当前数>0时  后面的均不符合条件
            if (nums[i] > 0) {
                break;
            }

            //todo
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;

            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    //todo

                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }


        }
        return ans;

    }


    @Test
    public void testThreeSum() {

        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> lists = threeSum(nums);

        Assert.assertEquals(2,lists.size());
        Assert.assertEquals("[[-1,-1,2],[-1,0,1]]",lists);
    }
}
