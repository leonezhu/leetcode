//package stack;
//
///**
// * @author XiaoXiong
// * @since 2019-11-22
// */
//public class CustomStack <T> {
//
//    private T[] items;
//
//    private int count;
//
//    private int size;
//
//
//    public CustomStack(int size) {
//
//        this.items = new T[size];
//        this.count = 0;
//        this.size = size;
//    }
//
//    public boolean push(T item) {
//        if (count == size) {
//            return false;
//        }
//        items[count] = item;
//        ++count;
//        return true;
//    }
//
//    public T pop() {
//        if (count == 0) {
//            return null;
//        }
//
//        T tmp = items[count - 1];
//        --count;
//        return tmp;
//
//    }
//
//
//}
