package thread;

public class ThreadDemo9 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("hello1");
        });

    }
}
