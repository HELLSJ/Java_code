package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo14 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i <= 1000; i++) {
                    result += i;
                }
                return result;
            }
        };
        //因为Thread没有提供构造函数来传入callable，
        //所以我们可以引入FutureTask类来作为Thread和callable的粘合剂
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        //这里的futureTask是未来的任务（因为当前任务还没执行完）执行完毕，去取结果的一个凭证
        Thread t = new Thread(futureTask);
        t.start();

        //接下来的代码不用join，直接使用futureTask获取到结果
        //futureTask.get()带有阻塞功能，如果线程还没执行完毕，get就会阻塞
        //线程执行完了，return的结果就会被get返回回来
        System.out.println(futureTask.get());
    }
}
