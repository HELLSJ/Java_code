package thread;

public class ThreadDemo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("start之前： "+t.isAlive());
        t.start();
        System.out.println("start之后： "+t.isAlive());
        Thread.sleep(2000);
        System.out.println("t结束之后： "+t.isAlive());
    }
}
