package thread;

/**
 * @author XiaoXiong
 * @since 2019/7/28
 */
public class MyRunnable implements Runnable {

    private String threadName;

    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(threadName + "运行，i = " + i);
        }
    }
}
