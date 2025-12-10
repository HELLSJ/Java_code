package Thread;

public class ThreadDemo13 {
    private static int sum = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int result = 0;
                for (int i = 0; i <= 1000; i++) {
                    result += i;
                }
                //此处想获取到结果就需要专门搞一个成员变量来保存上述计算结果
                sum = result;
            }
        });
        t.start();
        t.join();
        System.out.println("sum = " + sum);
    }
}
