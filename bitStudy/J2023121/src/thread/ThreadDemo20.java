package thread;
class Test{
    public int count = 0;
    synchronized public void add(){
        count++;
    }
}
public class ThreadDemo20 {
    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                t.add();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                t.add();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count: " + t.count);
    }
}
