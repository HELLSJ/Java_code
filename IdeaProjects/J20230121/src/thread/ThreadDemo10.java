package thread;

public class ThreadDemo10 {
    private static boolean isQuit = false;
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while(!isQuit){
                System.out.println("我是一个线程，工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程工作完毕");
        });
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("让进程结束");
        isQuit = true;
    }
}
