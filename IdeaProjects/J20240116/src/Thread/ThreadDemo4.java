package Thread;

class SingletonLazy{
    private volatile static SingletonLazy instance = null;//先初始化为null，不是立即初始化

    private static Object locker = new Object();
    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (locker) {
                if (instance == null) {
                    instance = new SingletonLazy();//首次调用getInstance才会创建出一个实例
                }

            }
        }
        return instance;
    }
    private SingletonLazy(){}
}
public class ThreadDemo4 {
}
