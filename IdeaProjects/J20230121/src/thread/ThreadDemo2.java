package thread;
class MyThread2 extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello thread");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread t = new MyThread2();
        t.start();

        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
