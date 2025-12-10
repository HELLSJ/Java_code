package Thread;

class MyBlockingQueue{
    private String[] elems = null;

    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private static Object locker = new Object();
    public MyBlockingQueue(int capacity){
        elems = new String[capacity];
    }

    public void put(String elem) throws InterruptedException {
        synchronized (locker){
            //新的元素放到tail指向的位置上
            while (size >= elems.length){
                //队列满了，需要下面这个代码阻塞
                locker.wait();
            }
            //新的元素要放到tail指向的元素上
            elems[tail] = elem;
            tail++;
            if(tail >= elems.length){
                tail = 0;
            }
            size++;
            //入队列成功后唤醒
            locker.notify();
        }
    }
    public String take() throws InterruptedException {
        String elem = null;
        synchronized (locker){
            while (size == 0){
                //队列空了，需要下面这个代码阻塞
                locker.wait();
            }
            elem = elems[head];
            head ++;
            if(head >= elems.length){
                head = 0;
            }
            size--;
            //出队列成功后唤醒
            locker.notify();
        }
        return elem;
    }
}

public class ThreadDemo6 {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(1000);
        //生产者
        Thread t1 = new Thread(()->{
            int n = 1;
            while(true){
                try {
                    queue.put(n + "");
                    System.out.println("生产元素 " + n);
                    n++;
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //消费者
        Thread t2 = new Thread(()->{
            while(true){
                try {
                    String n = queue.take();
                    System.out.println("消费元素 " + n);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
