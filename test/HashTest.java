package test;

/**
 * @author XiaoXiong
 * @since 2020/11/6
 */
public class HashTest {

    public static void main(String[] args) {


        int hash = 31;

        int len = 15;

        int ans = hash & (len - 1);

        int ans2 = hash % len;


        System.out.println(ans);
        System.out.println(ans2);

    }
}
