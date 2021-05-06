package singlenumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaoXiong
 * @since 2019/8/13
 */
public class SingleNumber {

    //https://leetcode-cn.com/problems/single-number/
    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    public static void main(String[] args) {

        System.out.println(3^1);
        System.out.println(3^2);
        System.out.println(3^3);
        System.out.println(3^2^3);

        System.out.println("-------------------");
        System.out.println(1^1);
        System.out.println(1^2); //这里结果为什么时3？
        System.out.println(1^3); //这里结果为什么时2？
        System.out.println(1^2^1);
//
//        int[] ints = {1,1,3,2,2};
//        SingleNumber singleNumber = new SingleNumber();
////        System.out.println(singleNumber.method1(ints));
//        System.out.println("result="+singleNumber.method2(ints));

    }

    public int method1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            count = count == null ? 1 : ++count;
            map.put(nums[i], count);
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                return integer;
            }
        }
        return -1;
    }

    // int[] ints = {1,1,2,2,2 3,4,3};
    //如果某个元素出现三次就会有问题
    //nt[] ints = {1,1,3,2,2};
    public int method2(int [] nums){
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
                System.out.println("ans="+ans);
            }
        }
        return ans;


    }

}
