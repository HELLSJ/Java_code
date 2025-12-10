package thread;

public class ThreadDemo21 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t = new Thread(()->{
            synchronized (locker){
                synchronized (locker){
                    System.out.println("hello");
                }
            }
        });
        t.start();
    }
}
