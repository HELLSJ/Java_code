package thread;
class MyThread5 extends Thread{
    @Override
    public void run() {
        System.out.println(this.getId() + ", " + this.getName());
    }
}
public class ThreadDemo16 {
    public static void main(String[] args) {
        MyThread5 t1 = new MyThread5();
        MyThread5 t2 = new MyThread5();
        t1.start();
        t2.start();
        System.out.println(t1.getId() + ", " + t1.getName());
        System.out.println(t2.getId() + ", " + t2.getName());
    }
}
