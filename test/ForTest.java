package test;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author XiaoXiong
 * @since 2020/11/25
 */
public class ForTest {
    public static void main(String[] args) {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if (j == 2) {
////                    break;
//                    continue;
//                }
//                System.out.println("j==" + j);
//            }
//            System.out.println("i==" + i);
//            System.out.println("----------------------------------");
//
//        }


//        List<String> set = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("nihao");

        List<List<String >> list = new ArrayList<>();

        List<String> innerList1 = Arrays.asList("hello", "nihao1","ni1hao");
        List<String> innerList2 = Arrays.asList("nihao", "hello");

        list.add(innerList1);
        list.add(innerList2);


        for (List<String> innerList : list) {

            if (set.containsAll(innerList)) {
                System.out.println("包含");
                return;
            }
        }

        System.out.println("不包含");



    }
}
/*
break;
j==0
j==1
i==0
----------------------------------
j==0
j==1
i==1
----------------------------------
j==0
j==1
i==2
----------------------------------
j==0
j==1
i==3


 */
