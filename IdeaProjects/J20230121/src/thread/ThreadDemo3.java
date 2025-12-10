package thread;
class MyThread3 implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("hello runnable");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo3 {
    public static void main(String[] args) {
        Runnable runnable = new MyThread3();//只是一段可执行的代码
        Thread t = new Thread(runnable);//还要搭配Thread类，才能真正在系统中创建出线程
        t.start();

        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
