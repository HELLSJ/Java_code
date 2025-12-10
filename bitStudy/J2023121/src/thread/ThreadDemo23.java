package thread;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

public class ThreadDemo23 {
    private volatile static int flag = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(flag == 0){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("t1进程结束");
        });

        Thread t2 = new Thread(()->{
            System.out.println("输入flag的值：");
            Scanner scanner = new Scanner(System.in);
            flag = scanner.nextInt();
        });
        t1.start();
        t2.start();
    }
}
