package Thread;

import java.util.Comparator;
import java.util.PriorityQueue;
//通过这个类来描述任务
class MyTimerTask implements Comparable<MyTimerTask> {
    //在什么时间点执行这个任务，用ms级别的时间戳
    private long time;
    //实际任务要执行的代码
    private Runnable runnable;
    public long getTime(){
        return time;
    }
    //delay是一个相对时间
    public MyTimerTask(Runnable runnable, long delay){
        this.runnable = runnable;
        //计算一下真正要执行任务的绝对时间，方便判断任务是否到达时间
        this.time = System.currentTimeMillis() + delay;
    }
    public void run(){
        runnable.run();
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int)(this.time - o.time);
    }
}
class MyTimer{
    //负责扫描任务队列
    private Thread t = null;
    //任务队列
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    private Object locker = new Object();
    public void schedule(Runnable runnable, long delay){
        synchronized (locker){
            MyTimerTask task = new MyTimerTask(runnable,delay);
            queue.offer(task);
            //添加新的元素之后就通知schedule
            locker.notify();
        }
    }

    //构造方法，创建扫描线程，让扫描线程来完成判定和执行
    public MyTimer(){
        t = new Thread(()->{
            //扫描线程就需要循环的反复扫描队首元素，然后判定队首任务时间是否到达
            //时间到了就执行任务并删除这个任务
            //时间没到就啥都不干

            while (true){
                try {
                    synchronized (locker) {
                        while (queue.isEmpty()) {
                            locker.wait();
                        }
                        MyTimerTask task = queue.peek();
                        //获取当前时间
                        long curTime = System.currentTimeMillis();
                        if (curTime >= task.getTime()) {
                            //当前时间已经到了任务时间，就可以执行任务了
                            queue.poll();
                            task.run();
                        } else {
                            //时间还没到，暂时先不执行
                            locker.wait(task.getTime() - curTime);
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public void cancel(){
        //结束 t 线程
        //interrupt
        
    }

}
public class ThreadDemo9 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3000");
            }
        },3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2000");
            }
        },2000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1000");
            }
        },1000);
        System.out.println("hello main");
    }
}
