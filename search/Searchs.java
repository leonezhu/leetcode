package search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author XiaoXiong
 * @since 2019-12-06
 */
public class Searchs {


    public static int binarySearch(int[] a, int n) {
        int low = 0;
        int high = a.length - 1;


        while (low <= high) {
//        int mid = low + (high - low) / 2;
            int mid = low + ((high - low) >> 1);
            if (a[mid] == n) {
                return mid;
            } else if (a[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static int binarySearchWithRecursive(int[] a, int value) {
        return binarySearchWithRecursiveInternally(a, 0, a.length - 1, value);
    }

    private static int binarySearchWithRecursiveInternally(int[] a, int low, int high, int value) {
        //递归的终止条件与循环的条件相反
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return binarySearchWithRecursiveInternally(a, mid + 1, high, value);
        } else {
            return binarySearchWithRecursiveInternally(a, low, mid - 1, value);
        }


    }


    @Test
    public void test() {

        int[] testArr = {1, 2, 3, 4, 5, 6, 7};
//        Assert.assertEquals(1, binarySearch(testArr, 2));
        Assert.assertEquals(1, binarySearchWithRecursive(testArr, 2));

    }


}
