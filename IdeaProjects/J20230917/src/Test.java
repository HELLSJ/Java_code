
class OuterClass{
    public int data1=1;
    public static int data2=2;//外部类可以定义静态属性
    private int data3=3;
    class InnerClass{
        public int data1 = 111;
        private int data4 = 4;
        public static final int data5 = 5;//可以
        private int data6 = 6;

        public void test(){
            System.out.println("InnerClass::test()");
            System.out.println(data1);
            System.out.println(OuterClass.this.data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
        }
    }
    public void test(){
        System.out.println("OuterClass:: test()");
    }
}

class Out {
    public int data1 = 1;
    public static int data2=2;
    private int data3 = 3;
    static class Innerclass{
        public int data4 =4;
        public static int data5 = 5;
        private int data6 = 6;

        public void test(){
            Out out = new Out();
            System.out.println("InnerClass::test()");
            System.out.println(out.data1);
            System.out.println(data2);
            System.out.println(out.data3);
            System.out.println(data4);
            System.out.println(data6);
        }
    }
    public void test(){
        System.out.println("Out: test()");
    }
}




interface IA{
    void test();
}
public class Test {
    public static void main1(String[] args) {
        IA a = new IA(){
            @Override
            public void test() {
                System.out.println("这是重写了接口的方法！");
            }
        };
        a.test();
    }
    public static void main(String[] args) {
        new IA(){
            @Override
            public void test() {
                System.out.println("这是重写了接口的方法！");
            }
        }.test();
    }











    public void func(){
        class AA{
            public int a;
        }

        AA aa = new AA();
        System.out.println(aa.a);
    }
    public static void main3(String[] args) {
        Out.Innerclass innerclass = new Out.Innerclass();
        innerclass.test();
    }
    public static void main1(String[] args) {
        //InnerClass innerClass = new InnerClass();//无法实例化
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.test();
    }
}

