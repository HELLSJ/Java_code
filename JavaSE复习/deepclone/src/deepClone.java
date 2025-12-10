class Student1 implements Cloneable {
    public int age;
    public Address addr;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student1 s = (Student1) super.clone(); // 浅拷贝
        s.addr = (Address) addr.clone();     // 再克隆引用对象（深拷贝）
        return s;
    }
}

public class deepClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student1 s1 = new Student1();
        s1.age = 10;
        s1.addr = new Address();
        s1.addr.city = "Beijing";

        Student1 s2 = (Student1) s1.clone();

        s1.addr.city = "Shanghai";
        System.out.println(s1.addr.city);
        System.out.println(s2.addr.city);
    }
}
