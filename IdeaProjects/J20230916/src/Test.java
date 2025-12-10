import java.util.Objects;

class Money implements Cloneable{
    public double m = 19.9;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}



class Person implements Cloneable{
    public String name;
    public int age;

    public Money money = new Money();


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //这里面克隆person，但没看到克隆money
        Person tmp = (Person) super.clone();
        tmp.money = (Money)this.money.clone();
        return tmp;
//        return super.clone();
    }

//    @Override
//    public boolean equals(Object obj) {
//        Person tm = (Person) obj;
//        return this.name.equals(tm.name) && this.age == tm.age;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
public class Test {
    public static void main(String[] args) {
        Person person = new Person("张三",10);
        Person person1 = new Person("张三",10);
        //System.out.println(person == person1);
        System.out.println(person.equals(person1));
    }
    public static void main222(String[] args) throws CloneNotSupportedException {
        Person person = new Person("张三",10);
        Person person1 = (Person) person.clone();//clone
        System.out.println("person "  + person.money.m);
        System.out.println("person1 "  + person1.money.m);
        System.out.println("===============");
        person.money.m = 99.99;
        System.out.println("person "  + person.money.m);
        System.out.println("person1 "  + person1.money.m);
    }
}
