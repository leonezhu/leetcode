package digui;

/**
 * @author XiaoXiong
 * @since 2019/8/13
 */
public class Digui {


    //古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？
    // https://blog.csdn.net/liujiding/article/details/77933064

    public static void main(String[] args) {
        Digui digui = new Digui();
        for (int i = 1; i <50 ; i++) {
            System.out.println(digui.digui(i));
        }
    }
    // 0 5 5 10 15 25。。。 第50个数的值
    public long digui(int x){
        if(x ==1){
            return 0;
        }
        if(x == 2){
            return 5;
        }
        //第3个数的值=第一个数的值(didui(3-2))+第二个数的值（digui(3-1)）
        return digui(x - 2) + digui(x - 1);
    }

}
