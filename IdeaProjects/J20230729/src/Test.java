public class Test {
    public static void mainFun(String[] args) {
        System.out.println(Integer.MIN_VALUE);//-2147483648
        System.out.println(Integer.MAX_VALUE);//2147483647
    }

    public static void mainLong(String[] args) {
        long a = 10;
        System.out.println(a);
        System.out.println(Long.MAX_VALUE);//9223372036854775807
        System.out.println(Long.MIN_VALUE);//-9223372036854775808
    }

    public static void mainShort(String[] args) {
        short a = 10;
        System.out.println(a);
        System.out.println(Short.MIN_VALUE);//-32768
        System.out.println(Short.MAX_VALUE);//32767
    }

    public static void mainByte(String[] args) {
        byte a = 127;
        System.out.println(a);
        byte b = (byte)(a + 1);
        System.out.println(b);
    }

    public static void main5(String[] args) {
        double a = 1.0;
        double b = 2.0;
        System.out.println(a / b); // 输出 0.5 吗？
    }

    public static void main6(String[] args) {
        String str = "hello";


        String str2 = "345";
        int val = Integer.valueOf(str2);
        System.out.println(val+1);//346

        int p = 100;
        String str3 = String.valueOf(p);
        System.out.println(str3);//100

        int a = 10;
        int b = 20;
        System.out.println("a = " + a + " b = "+ b );
        System.out.println(a+b + "a + b ");
        System.out.println("a + b = "+a+b);

    }

    public static void main7(String[] args) {
//        System.out.println(5/2);
//        System.out.println((float)5/2);
//        System.out.println(5/(float)2);
//        System.out.println((float)(5/2));
//        System.out.println(10%3);
//        System.out.println(-10%3);
//        System.out.println(10%-3);
//        System.out.println((-10%-3));
        System.out.println(10/0);
    }

    public static void main(String[] args) {
//        int a = 4;
//        double d = 5.0;
//        double f = a + d;
//        System.out.println(f);//?
//        a += d;
//        System.out.println(a);//?
//        int a = 10;
//        //int b = a++;
//        int c = ++a;
//
//        System.out.println(a);//11
//        System.out.println(c);
//        //System.out.println(b);//10
//        int a = 10;
//        a = a++;
//        System.out.println(a);
        byte a = 130;
        float b = 3.5;
    }
}
