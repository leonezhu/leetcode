package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaoXiong
 * @since 2020/10/28
 */
public class CollectionTest {

    public static void mapTest() {


//        Map map = new TreeMap<String, String>();  // 1 2 3
        Map map = new HashMap();   // 1 2 3
//        Map map = new LinkedHashMap() {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry eldest) {
//                return size() > 3;
//            }
//
//        }; // 2 3 1

        map.put("2", "bbb");
        map.put("3", "c");
        map.put("1", "aaaa");


        map.put("4", "d"); //3 1 4

        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

    }

    public static void test() {

        int a = 3;

//        int b = 2;

        int b = "哈啊哈哈".hashCode();

        System.out.println(b);

        byte bb = new Integer(b).byteValue();
//        System.out.println(bb);

        int c = b >>> 16;

        System.out.println(c);

        int d = b ^ c;

        System.out.println(d);
        System.out.println(d & 15);
        System.out.println(d & 16);
        System.out.println(d & 17);
        System.out.println(d & 18);
        System.out.println(d & 19);

    }


    public static void main(String[] args) {
        test();
//        mapTest();
    }

}
