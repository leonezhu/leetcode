package singleton;

/**
 * @author XiaoXiong
 * @since 2019/7/23
 */
public class Singleton {

    //双检锁/双重校验锁
    //如果是饿汉式： Singleton instance = new Singleton();
    private static volatile Singleton instance = null;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {//尽量避免重复进入块
            synchronized (Singleton.class) {//同步.class 意味着对同步类方法调用
                if (instance == null) {
                    return new Singleton();
                }
            }
        }
        return instance;
    }
}
