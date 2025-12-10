
import java.util.*;
public class Test2 {
    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        int[] array = {1,2,3};
        System.out.println(Arrays.toString(array));
    }
    public static void main1(String[] args) {
//        Person person = new Person("张三",88);//可以在这里面来初始化
//        person.name = "张三";
        Person person = new Person();
        person.setName("张三");
        System.out.println(person.getName());
    }
}
