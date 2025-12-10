package thread;

public class ThreadDemo15 {
    private static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            long tmp = 0;
            for (long i = 1; i <= 50_0000_0000L ; i++) {
                tmp += i;
            }
            result += tmp;
        });
        Thread t2 = new Thread(()->{
            long tmp = 0;
            for (long i = 50_0000_0001L; i < 100_0000_0000L; i++) {
                tmp += i;
            }
            result += tmp;
        });
        long beg = System.currentTimeMillis();
        t.start();
        t2.start();

        //使用sleep，但是不知道t线程要执行多久，sleep里面的时间不好填
        //Thread.sleep(1000);

        //使用join，严格按照t线程执行结束来作为等待条件
        //什么时候t运行结束，什么时候join结束等待
        t.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("result: " + result);
        System.out.println("time = " + (end-beg) + " ms");
    }
}
