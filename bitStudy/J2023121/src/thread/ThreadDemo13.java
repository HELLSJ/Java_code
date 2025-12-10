package thread;

public class ThreadDemo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("我是一个线程, 正在工作中...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程执行完毕!");
        });

        t.start();

        Thread.sleep(3000);
        // 使用一个 interrupt 方法, 来修改刚才标志位的值
        System.out.println("让 t 线程结束");
        t.interrupt();
    }
}
