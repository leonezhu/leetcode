package sort;

import org.junit.Test;
import sort.division.MergeSort;

import java.util.Arrays;

/**
 * @author XiaoXiong
 * @since 2019-12-04
 */
public class TestSort {

    private int[] intArr = {1, 5, 2, 3, 6, 4, 8};


    @Test
    public void testBubbleSort() {

        System.out.println("bubble sort before");
        Arrays.stream(intArr).forEach(i -> System.out.print(i + " "));


        System.out.println();
        System.out.println("sort after");

        BubbleSort.sort(intArr, intArr.length);
        Arrays.stream(intArr).forEach(i -> System.out.print(i + " "));
        System.out.println();

    }


    @Test
    public void testMergeSort() {


        System.out.println("merge sort before");
        Arrays.stream(intArr).forEach(i -> System.out.print(i + " "));


        System.out.println();
        System.out.println("sort after");

        MergeSort.mergeSort(intArr, intArr.length);
        Arrays.stream(intArr).forEach(i -> System.out.print(i + " "));
        System.out.println();


    }
}
