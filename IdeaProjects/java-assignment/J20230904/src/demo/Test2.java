package demo;

class Base{
    public int a = 99;
}
class Derived extends Base{
    public int a = 199;

    public void test(){
        System.out.println(a);//打印子类的
        System.out.println(super.a);//打印父类的
    }
}
public class Test2{
    public static void main(String[] args) {
        Derived derived = new Derived();
        derived.test();
    }
}
