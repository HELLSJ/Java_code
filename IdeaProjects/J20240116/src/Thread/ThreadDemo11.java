package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MyThreadPoolExecutor{
    private List<Thread> threadList = new ArrayList<>();
    //创建一个用来保存任务的队列
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);
    //通过n指定创建多少个线程
    public MyThreadPoolExecutor(int n){
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(()->{
                while (true) {
                    try {
                        //此处take带有阻塞功能，如果此处队列为空，take就会阻塞
                        Runnable runnable = queue.take();
                        //取出一个任务就执行一个任务
                        runnable.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            threadList.add(t);
        }
    }
    public void submit(Runnable runnable) throws InterruptedException{
        queue.put(runnable);
    }
}
public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException{
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(4);
        for (int i = 0; i < 1000; i++) {
            int n = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务 "+ n + ", 当前线程为：" + Thread.currentThread().getName());
                }
            });
        }
    }
}
