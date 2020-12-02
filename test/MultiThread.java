package test;

/**
 * @author XiaoXiong
 * @since 2020/10/21
 */
public class MultiThread extends Thread {


    public MultiThread(String threadName) {
        this.setName(threadName);
    }

    @Override
    public void run() {

        System.out.println("hello thread:"+Thread.currentThread().getName());

    }


    public static void main(String[] args) throws  Exception {


        while (true) {
            String ranDomName = Math.random() + "";
            new MultiThread(ranDomName).start();

            Thread.sleep(1000);

        }
    }

}
