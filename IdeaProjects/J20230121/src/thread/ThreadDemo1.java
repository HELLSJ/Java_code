package thread;

//1. 创建一个自己的类来继承Thread（在java.lang里面，自动导包）
class MyClass extends Thread{
    @Override
    public void run(){
        System.out.println("hello world");
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        //2. 根据刚才的类创建出实例（线程实例才是真正的线程）
        Thread t = new MyClass();
        //3.调用Thread的start方法，才会真正调用API，在系统内核中创建出线程
        t.start();
    }
}
