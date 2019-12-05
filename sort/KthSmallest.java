package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author XiaoXiong
 * @since 2019-12-05
 */
public class KthSmallest {


    public static int kthSmallest(int[] a, int k) {

        if (a == null || a.length < k) {
            return -1;
        }


        int partition = partition(a, 0, a.length - 1);
        while (partition + 1 != k) {
            if (partition >= k) {
                partition = partition(a, 0, partition - 1);
            } else {
                partition = partition(a, partition + 1, a.length - 1);
            }
        }


        return a[partition];
    }

    private static int partition(int[] a, int left, int right) {

        int pivot = a[right];

        int index = left;

        for (int i = left; i < right; i++) {
            if (a[i] <= pivot) {
                swap(a, i, index);
                index++;
            }
        }

        swap(a, index, right);

        return index;

    }

    private static void swap(int[] a, int p, int q) {

        if (p == q) {
            return;
        }
        int tmp = a[p];
        a[p] = a[q];
        a[q] = tmp;

    }


    @Test
    public void testKthSmallest() {
        int[] testArr = {1, 5, 2, 8, 6, 3, 4};


        Assert.assertEquals(1, kthSmallest(testArr, 1));
        Assert.assertEquals(2, kthSmallest(testArr, 2));
        Assert.assertEquals(3, kthSmallest(testArr, 3));
        Assert.assertEquals(4, kthSmallest(testArr, 4));
        Assert.assertEquals(8, kthSmallest(testArr, 7));


    }
}
