package thread;
public class ThreadDemo19 {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //随便创建一个对象
        Object locker = new Object();
        //创建两个线程，每个线程都针对上述count变量循环自增5w次
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                synchronized(locker){
                    count++;
                }

            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                synchronized(locker){
                    count++;
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("count: " + count);
    }
}
