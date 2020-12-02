package array;

import java.util.*;

/**
 * @author XiaoXiong
 * @since 2020/3/17
 */
public class MergerTwoSortedArray {


    /**
     * 合并两个有序集合
     *
     * @param l1
     * @param l2
     * @return
     */
    public static List merge(List<Integer> l1, List<Integer> l2) {

        List result = new ArrayList();

        int i = 0, j = 0;

        //1 先遍历一遍  其中集合中有最大元素的集合未遍历完
        while (j < l2.size() && i < l1.size()) {
            if (l1.get(i) < l2.get(j)) {
                result.add(l1.get(i));
                i++;
            } else {
                result.add(l2.get(j));
                j++;
            }
        }

        //如果未遍历完的集合是l1
        while (i < l1.size()) {
            result.add(l1.get(i));
            i++;
        }

        //如果未遍历完的集合是l2
        while (j < l2.size()) {
            result.add(l2.get(j));
            j++;
        }

        return result;
    }
    public static List merge2(List<Integer> l1, List<Integer> l2) {
        List result = new ArrayList();
        result.addAll(l1);
        result.addAll(l2);
        Collections.sort(result);
        return result;
    }


    public static void main(String[] args) {
        List l1 = Arrays.asList(1, 3, 5);
        List l2 = Arrays.asList(2, 3, 4);

//        List result = merge(l1, l2);
        List result = merge2(l1, l2);


        result.forEach(e -> System.out.println(e));

    }

}
