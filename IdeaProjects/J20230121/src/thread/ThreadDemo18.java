package thread;

public class ThreadDemo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("线程运行中。。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(t.getState());
        t.start();
        Thread.sleep(500);
        System.out.println(t.getState());
        t.join();
        System.out.println(t.getState());
    }
}
