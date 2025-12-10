package Thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ThreadDemo16 {
    public static void main(String[] args) throws InterruptedException {
        //构造方法中写一个10表示有10个任务要执行
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int id = i;
            Thread t = new Thread(()->{
                Random random = new Random();
                int time = (random.nextInt(5) + 1) * 1000;
                System.out.println("线程 " + id + " 开始下载");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程 " + id + " 结束下载");
                //告知countDownLatch线程执行结束了
                latch.countDown();
            });
            t.start();
        }
        //通过这个await操作等待所有任务结束
        latch.await();
        System.out.println("所有任务都已完成");
    }
}
