package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo10 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
