import java.util.ArrayList;

class Food {

}
class Fruit extends Food {

}
class Apple extends Fruit {

}
class Banana extends Fruit {

}
class Plate<T> { // 设置泛型
    private T message ;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

}
public class Test2 {
    public static void fun2(Plate<? super Fruit> temp) {
        temp.setMessage(new Apple());
        temp.setMessage(new Banana());


        Fruit fruit = (Fruit) temp.getMessage();
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        Plate<Fruit> plate = new Plate<>();
        Plate<Food> plate2 = new Plate<>();

        fun2(plate);
        fun2(plate2);
    }
    public static void fun(Plate<? extends Fruit> temp){
        Fruit fruit = temp.getMessage();
        System.out.println(fruit);
    }
    public static void main1(String[] args) {
        Plate<Apple> plate = new Plate<>();
        Plate<Banana> plate1 = new Plate<>();
        fun(plate);
        fun(plate1);
    }
}
