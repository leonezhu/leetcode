package a_getoffer;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e
 *
 * @author XiaoXiong
 * @since 2020-01-03
 */
public class FindFromTwoDimensionalArray {


    public static boolean find(int target, int[][] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int i1 = 0; i1 < arr[i].length; i1++) {

                if (arr[i][i1] == target) {
                    return true;
                }

            }

        }

        return false;
    }


    /**
     * 左下法：
     * 观察题干中描述的二维数组的特征：
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序
     * 可以知道 ：即对于左下角的值 m，m 是该行最小的数，是该列最大的数
     *
     * @param target
     * @param arr
     * @return
     */
    public static boolean findSmartly(int target, int[][] arr) {

        int rows = arr.length;
        if (rows == 0) {
            return false;
        }

        int cols = arr[0].length;
        if (cols == 0) {
            return false;
        }

        //二维数据最左下的数
        int row = rows - 1;
        int col = 0;

        while (row >= 0 && col < rows) {
            if (arr[row][col] < target) {
                col++;
            } else if (arr[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }

        return false;
    }


    @Test
    public void test() {


        int[][] arr = new int[2][4];

        arr[0] = new int[]{1, 4, 7, 11};
        arr[1] = new int[]{2, 5, 8, 12};


        Assert.assertTrue(find(5, arr));
        Assert.assertTrue(findSmartly(5, arr));
        Assert.assertFalse(find(6, arr));
        Assert.assertFalse(findSmartly(6, arr));

    }
}
