package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author XiaoXiong
 * @since 2019-12-04
 */
public class Sort {

    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                //内层完整循环一次 如果都没有数据交换 则表示数组已经排序好了
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }

            }
            if (!flag) {
                break;
            }
        }

    }


    public static void insertionSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {

            int value = a[i];
            int j = i - 1;

            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }


    }


    public static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {

            int min = a[i];
            for (int j = i+1; j < n; j++) {
                if (min > a[j]) {
                    min = a[j];
                    a[j] = a[i];
                }
            }
            a[i] = min;

        }

    }


    private int[] intArr = {1, 5, 2, 3, 6, 4, 8};


    @Test
    public void testSort() {

        System.out.println("bubble sort before");
        Arrays.stream(intArr).forEach(i -> System.out.print(i + " "));


        System.out.println();
        System.out.println("sort after");

//        bubbleSort(intArr, intArr.length);
//        insertionSort(intArr, intArr.length);
        selectionSort(intArr, intArr.length);
//        MergeSort.mergeSort(intArr, intArr.length);
        Arrays.stream(intArr).forEach(i -> System.out.print(i + " "));
        System.out.println();

    }


}
