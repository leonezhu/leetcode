package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author XiaoXiong
 * @since 2019-12-04
 */
public class Sorts {


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

//            int min = a[i];
//            for (int j = i + 1; j < n; j++) {
//                //这样子 每次对比 发现小的就交换 不好，应该将最小的index记录下来结束这层循环再交换
//                if (min > a[j]) {
//                    min = a[j];
//                    a[j] = a[i];
//                }
//            }
//            a[i] = min;

            //优化后

            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }

            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;

        }

    }

    /**
     * 归并排序
     *
     * @param a
     * @param n
     */
    public static void mergeSort(int[] a, int n) {

        mergeSortInternally(a, 0, n - 1);
    }

    private static void mergeSortInternally(int[] a, int left, int right) {

        //递归终止条件
        if (left >= right) {
            return;
        }

        //这里等效于 (begin+end)/2 可以避免begin+end 大于int的最大值
        int middle = left + (right - left) / 2;

        //分治递归
        mergeSortInternally(a, left, middle);
        mergeSortInternally(a, middle + 1, right);

        merge(a, left, middle, right);
//        mergeBySentry(a, left, middle, right);
    }

    private static void merge(int[] a, int left, int middle, int right) {

        int i = left;
        int j = middle + 1;
        int k = 0;

        //临时数组 存左右两边的数据
        int[] tmp = new int[right - left + 1];

        while (i <= middle && j <= right) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        int start = i;
        int end = middle;

        //判断左右两边 哪边还有值没有放入tmp中
        if (j <= right) {
            start = j;
            end = right;
        }
        //将剩余的值放入tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        //将排序且合并好的值覆盖原先数组中的位置 所以是left+l
        for (int l = 0; l <= right - left; l++) {
            a[left + l] = tmp[l];
        }


    }

    private static void mergeBySentry(int[] a, int left, int middle, int right) {

        //原本左边的数组大小为 middle-left+1 再 +1 用于存放哨兵   left middle right 是数组下标
        int[] leftArr = new int[middle - left + 2];
        //原本右边的数组大小为 right- (middle +1)+1  再 +1 用于存放哨兵
        int[] rightArr = new int[right - middle + 1];

        //设置leftArr及rightArr大小时就确定了左边数组是包含middle这个数
        //所以填充leftArr时 i<=middle-left  填充rightArr时 i< right-middle 没有=

        for (int i = 0; i <= middle - left; i++) {
            leftArr[i] = a[left + i];
        }
        leftArr[middle - left + 1] = Integer.MAX_VALUE;


        for (int i = 0; i < right - middle; i++) {
            rightArr[i] = a[middle + 1 + i];
        }
        rightArr[right - middle] = Integer.MAX_VALUE;


        int i = 0;
        int j = 0;
        int k = left;
        while (k <= right) {
            if (leftArr[i] <= rightArr[j]) {
                a[k++] = leftArr[i++];
            } else {
                a[k++] = rightArr[j++];
            }
        }

    }

    public static void quickSort(int[] a, int n) {

        quickSortInternally(a, 0, n - 1);

    }

    private static void quickSortInternally(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = partition(a, left, right);
        //因为中间那个数位置一定是排好的 所以下面两个递归都不该包含中间那个数
        quickSortInternally(a, left, middle - 1);
        quickSortInternally(a, middle + 1, right);
    }

    private static int partition(int[] a, int left, int right) {

        //将最右边的数作为中间锚点
        int pivot = a[right];
        //锚点对应数组的下标
        int index = left;

        for (int i = left; i < right; i++) {
            //比锚点小的数放在锚点左边
            if (a[i] < pivot) {
                if (index == i) {
                    index++;
                } else {
                    int tmp = a[index];
                    a[index++] = a[i];
                    a[i] = tmp;
                }
            }
        }

        //将某点交换至对应位置
        int tmp = a[index];
        a[index] = a[right];
        a[right] = tmp;


        return index;

    }


    int[] intArr = {1, 5, 2, 8, 6, 3, 4};

    @Test
    public void testSort() {

        System.out.println("sort before");
        Arrays.stream(intArr).forEach(i -> System.out.print(i + " "));


        System.out.println();
        System.out.println("sort after");

//        bubbleSort(intArr, intArr.length);
//        insertionSort(intArr, intArr.length);
//        selectionSort(intArr, intArr.length);
//        mergeSort(intArr, intArr.length);
//        quickSort(intArr, intArr.length);
        javaInsertionSort(intArr, 0, intArr.length);
        Arrays.stream(intArr).forEach(i -> System.out.print(i + " "));
        System.out.println();

    }


    /**
     * Java Arrays 中当数组长度小于7时使用的插入排序
     *
     * @param dest
     * @param low
     * @param high
     */
    public static void javaInsertionSort(int[] dest, int low, int high) {

        for (int i = low; i < high; i++) {
            for (int j = i; j > low && ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--) {
                swap(dest, j, j - 1);
            }
        }
    }

    private static void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }


}
