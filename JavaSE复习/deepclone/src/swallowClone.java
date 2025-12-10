class Student implements Cloneable {
    public int age;
    public Address addr;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student s = (Student) super.clone(); // Ç³¿½±´
        return s;
    }
}

class Address implements Cloneable {
    public String city;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class swallowClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student();
        s1.age = 10;
        s1.addr = new Address();
        s1.addr.city = "Beijing";

        Student s2 = (Student) s1.clone();

        s1.addr.city = "Shanghai";
        System.out.println(s1.addr.city);
        System.out.println(s2.addr.city); // Ò²±ä³É Shanghai£¡£¡
    }
}