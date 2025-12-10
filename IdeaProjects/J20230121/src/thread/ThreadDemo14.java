package thread;

public class ThreadDemo14 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("我是一个线程，正在工作");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        t.join();
        System.out.println("这是主线程, 期望这个日志在t线程后打印");
    }
}
