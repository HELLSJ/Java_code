package Thread;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadDemo7 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("hello timer 3000");
            }
        },3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello timer 2000");
            }
        },2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello timer 1000");
            }
        },1000);
        System.out.println("hello main");
    }
}
