package sort.division;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author XiaoXiong
 * @since 2019-12-04
 */
public class MergeArray {


    public void mergerSort(int[] inArr, int n) {

        mergerSort(inArr, 0, n - 1);

    }

    public void mergerSort(int[] intArr, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int middle = begin + end / 2;
        mergerSort(intArr, begin, middle);
        mergerSort(intArr, middle + 1, end);
    }


}
