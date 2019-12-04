package sort;

/**
 * @author XiaoXiong
 * @since 2019-12-04
 */
public class BubbleSort {


    public static void sort(int[] a, int n) {
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

}
