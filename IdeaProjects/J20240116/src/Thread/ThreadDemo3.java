package Thread;
//期望这个类只有唯一的实例
class Singleton{
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
    private Singleton(){

    }
}

public class ThreadDemo3 {
    public static void main(String[] args) {
//        Singleton s = new Singleton();
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
