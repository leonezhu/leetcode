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


        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return ans;
        }

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            //当前数>0时  后面的均不符合条件
            if (nums[i] > 0) {
                break;
            }

            //因为数组前面是排序过的 所以当前值如果与左边下一个数一样 会导致相同的结果 故++
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;

            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                //得保证任何条件下都对l或者r有操作
                if (sum == 0) {
                    //如果找到符合条件的值 加入结果集
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //并判断确认双指针的动作

                    //因为数组前面是排序过的 所以当前值如果与左边下一个数一样 会导致相同的结果 故++
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
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

        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> ans = threeSum(nums);

        Assert.assertEquals(2, ans.size());


        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(Arrays.asList(-1, -1, 2));
        expectedList.add(Arrays.asList(-1, 0, 1));

        Assert.assertEquals(expectedList, ans);
    }
}
