package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author XiaoXiong
 * @since 2020-03-12
 */
public class ThreadPoolDemo {


    public static ExecutorService executor = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>(1024),
        new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {
//
//        for (int i = 0; i < 1000; i++) {
//            String str = "Thread=" + Thread.currentThread().getName() + ", i=" + i;
//
//            executor.execute(() -> System.out.println(str));
//        }
//
//        executor.shutdown();


        System.out.println(and(1001));
        System.out.println(and(1000));
        System.out.println(and(2));
        System.out.println(and(3));
        System.out.println(and(4));
        System.out.println(and(8));

        int n = 11111;

        //计算2进制中有多少个1
        int count = 0;
        while (n != 0) {
            System.out.println("n=" + n);
            count++;
//            n = and(8);
            n = (n - 1) & n;

        }

        System.out.println("有" + count + "个1");
    }


    public static int and(int n) {
        //如果是2的整数次幂的值，那结果一定是0
        return n & (n - 1);
    }
}
