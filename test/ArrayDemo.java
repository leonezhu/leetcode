package test;

/**
 * @author XiaoXiong
 * @since 2019-11-05
 */
public class ArrayDemo {


    public static void main(String[] args) {
        int oldCapacity = 10;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        System.out.println("new size =" + newCapacity);

    }
}
