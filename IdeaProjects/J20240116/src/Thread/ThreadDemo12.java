package Thread;
import java.util.concurrent.atomic.AtomicInteger;
public class ThreadDemo12 {
    //private static int count = 0;//这里加static的作用？
    //不使用原生的int，而是替换成AtomicInteger
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                //count++;
                count.getAndIncrement();
                //++count;
                //count.incrementAndGet();
                //count += n;
                //count.getAndAdd(n);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                //count++;
                count.getAndIncrement();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("count = "+count.get());
    }
}
