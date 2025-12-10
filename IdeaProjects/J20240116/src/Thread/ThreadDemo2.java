package Thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(()->{
            synchronized (locker){
                System.out.println("t1 wait之前");
                try {
                    locker.wait();//wait, sleep和1join都可能被interrupt提前唤醒，需要放到try-catch里面
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1 wait之后");
            }
        });
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(1000);
                synchronized (locker){
                    System.out.println("t2 notify之前");
                    locker.notify();
                    System.out.println("t2 notify之后");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
