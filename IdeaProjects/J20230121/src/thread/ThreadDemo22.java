package thread;

public class ThreadDemo22 {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(()->{
            synchronized (A){
                //sleep一下，给t2时间能拿到B
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //尝试获取B，但没有释放A
                synchronized (B){
                    System.out.println("t1拿到两把锁");
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (A){
                //sleep一下，给t1时间能拿到A
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //尝试获取A，但是没有释放B
                synchronized (B){
                    System.out.println("t2拿到两把锁");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
