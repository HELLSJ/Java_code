package demo;

class Animal{//抽取出来的类
    public String name;
    public int age;
    public void eat(){
        System.out.println(this.name + "正在吃饭");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        //System.out.println("Animal(String name, int age)");
    }
}
//拓展
class Dog extends Animal{//狗继承了Animal
    public Dog(String name, int age){
        super(name, age);
        //System.out.println("Dog(String name, int age)");
    }
    public void bark() {
        System.out.println(this.name+ " 正在旺旺叫！");
    }
    @Override
    public void eat(){
        System.out.println(this.name + "正在吃狗粮！");
    }
}


class Cat extends Animal{

    public Cat(String name, int age) {
        super(name, age);
    }

    public void miaomiao() {
        System.out.println(this.name+" 正在喵喵叫！");
    }

    @Override
    public void eat() {
        System.out.println(this.name+" 正在吃猫粮！");
    }
}

class Test{
    public static void main(String[] args) {
        Animal animal = new Dog("圆圆",19);
        //animal.bark();
//    Dog dog = (Dog)animal;
//    dog.bark();
        //如果animal引用的对象是Cat对象的实例
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;

            cat.miaomiao();
        }else{
            System.out.println("好吧!");
        }
    }


    public static void eatFun(Animal animal){
        animal.eat();
    }

    public static void main23(String[] args) {
        Dog dog = new Dog("圆圆", 19);
        eatFun(dog);

        Cat cat = new Cat("咪咪", 1);
        eatFun(cat);
    }
    public static Animal func2(){
        Dog dog = new Dog("圆圆",10);
        return dog;
    }

    public static void func1(Animal animal){

    }
    public static void main222(String[] args) {
        Dog dog = new Dog("圆圆",10);
        func1(dog);
    }
    public static void main666(String[] args) {
        Animal animal = new Dog("圆圆",10);
        animal.eat();
    }
}


