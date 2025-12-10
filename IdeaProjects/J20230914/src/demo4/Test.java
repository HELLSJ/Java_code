package demo4;

import javax.print.attribute.standard.RequestingUserName;

//抽象类Animal
abstract class Animal{
    public String name;
    public int age;

    public Animal(String name, int age){
        this.name=name;
        this.age=age;
    }
//    public void fly(){}
//    public void run(){}
//    public void swim(){}

    public abstract void eat();
}

//在动物里面，有的会飞有的会游有的会跑
//但我们不能在Animal类里面定义这三个方法因为不是每个动物都会飞或游或跑
//但这其实是一个行为标准
//三个接口
interface IFly{
    void fly();
}
interface IRun{
    void run();
}
interface ISwim{
    void swim();
}
//狗是一个动物，具备跑的功能
//鼠标放extends ALT+ENTER可以快速构造方法
//鼠标放Animal抽象类 ALT+ENTER可以快速重写方法
class Dog extends Animal implements IRun{

    Dog(String name, int age){
        super(name,age);
    }
    @Override
    public void run() {
        System.out.println(this.name+" 在用四条腿跑步");
    }

    @Override
    public void eat() {
        System.out.println(this.name+" 正在吃");
    }
}

class Frog extends Animal implements IRun,ISwim{
    public Frog(String name, int age){
        super(name, age);
    }

    @Override
    public void run() {
        System.out.println(this.name+" 正在用两条腿跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name+" 正在蛙泳");
    }

    @Override
    public void eat() {
        System.out.println(this.name+" 正在吃蛙粮");
    }
}

class Duck extends Animal implements IRun, ISwim, IFly{

    public Duck(String name, int age) {
        super(name, age);
    }

    @Override
    public void fly() {
        System.out.println(this.name+" 正在用翅膀飞");
    }

    @Override
    public void run() {
        System.out.println(this.name+" 正在撅着屁股跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name+" 正在用两只脚划水");
    }

    @Override
    public void eat() {
        System.out.println(this.name+" 正在吃鸭粮");
    }
}

class Robot implements IRun{
    @Override
    public void run() {
        System.out.println("机器人 正在用两只脚跑路");
    }
}

public class Test {
    public static void func1(Animal animal){
        animal.eat();
    }
    public static void running(IRun iRun){
        iRun.run();
    }
    public static void flying(IFly iFly){
        iFly.fly();
    }
    public static void swimming(ISwim iSwim){
        iSwim.swim();
    }


    //接口的意义：只要具备这个功能，我都能用
    public static void main(String[] args) {
        running(new Duck("唐老鸭",10));
        running(new Dog("二狗子",10));
        running(new Frog("青蛙",10));

        running(new Robot());//不管是不是动物


        System.out.println("================");
        flying(new Duck("唐老鸭",10));


        System.out.println("================");
        swimming(new Duck("唐老鸭",10));
        swimming(new Frog("青蛙",10));

    }
    public static void main1(String[] args) {
        //多态
        func1(new Duck("唐老鸭",10));
        func1(new Dog("二狗子",10));
        func1(new Frog("青蛙",10));
    }
}
