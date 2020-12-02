package array;

import java.util.Arrays;

/**
 * 实现一个支持动态扩容的数组
 * 实现一个大小固定的有序数组，支持动态增删改操作
 * 实现两个有序数组合并为一个有序数组
 *
 * @author XiaoXiong
 * @since 2020/3/17
 */
public class CustomArray<E> {

    Object[] elementData;

    /**
     * 当前数据元素个数
     */
    private int size;


    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 3;


    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public CustomArray(int initCapacity) {
        if (initCapacity > 0) {
            elementData = new Object[initCapacity];
        } else if (initCapacity == 0) {
            elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("illegal capacity:" + initCapacity);
        }
    }

    public CustomArray() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public boolean add(E e) {
        ensureCapacityInternal(size + 1);

        elementData[size++] = e;

        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }


    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    public int size() {
        return this.size;
    }

    private void grow(int minCapacity) {

        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 0); //1.5倍扩容
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public E remove(int index) {

        E oldElement = (E) elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        elementData[--size] = null;

        return oldElement;

    }

    public E get(int index) {
        return (E) elementData[index];
    }


    public static void main(String[] args) {

        CustomArray list = new CustomArray();

//        List list = new ArrayList();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("list size = " + list.size());

        System.out.println("----------");

        int remove = (int) list.remove(3);
        System.out.println("remove num = " + remove);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("----------");

        System.out.println("list size = " + list.size());
    }
}
