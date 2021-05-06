package thread;

/**
 * @author XiaoXiong
 * @since 2019/7/28
 */
public class MyRunnableDemo {

    public static void main(String[] args) {
        MyRunnable mr1 = new MyRunnable("线程1");
        MyRunnable mr2 = new MyRunnable("线程2");

        Thread t1 = new Thread(mr1);
        Thread t2 = new Thread(mr2);

        t1.start();
        t2.start();

    }
}
