package thread;

/**
 * @author XiaoXiong
 * @since 2019/7/28
 */
public class MyThreadDemo {

    public static void main(String[] args) {
        MyThread m1 = new MyThread("线程A");
        MyThread m2 = new MyThread("线程B");

        m1.start();
        m2.start();

    }
}
