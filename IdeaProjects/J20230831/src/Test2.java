class Person {
    //属性  成员变量: 定义在类中，方法外部的变量
    public String name;
    public int age;

    //行为    普通的成员方法
    public void sleep(){

    }

    //静态成员方法
    public static void staticMethod() {

    }
}

//自定义的类型 -> 你定义的一个 Java当中 没有的类型
class PetDog {
    public String name;//名字
    public String color;//颜色
    // 狗的属性
    public void barks() {
        System.out.println(name + ": 旺旺旺~~~");
    }

    // 狗的行为
    public void wag() {
        System.out.println(name + ": 摇尾巴~~~");
    }
}
public class Test2 {

}
