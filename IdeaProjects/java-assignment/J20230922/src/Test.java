public class Test {


    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);

        Integer a1 = 200;
        Integer b1 = 200;
        System.out.println(a1 == b1);

    }

    public static void main2(String[] args) {
        Integer a = 10;
        int i = a;
        System.out.println(i);

        int aa = a.intValue();

        double d = a.doubleValue();

        System.out.println(d);
    }




    public static void main1(String[] args) {
        Integer a = 10;//装包   自动装箱
        int i = 99;
        Integer b = i;
        //基本类型 给转变为 包装类型
        System.out.println(a);
        System.out.println(b);
        Integer aa = Integer.valueOf(10);//显示装箱
    }
}
