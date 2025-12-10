class Student{
    /**
     * 成员属性 / 成员变量： 定义在方法外部，类内部的变量
     *
     * 成员变量
     *      1. 静态成员变量
     *      2.普通成员变量->
     */
    public String name ;
    public int age ;

    public static String classroom = "110";
    public Student(){
//        this.name = "鼠标";
//        this.age = 9;
//        System.out.println("Student()....");
        //调用其他构造方法->只能在构造方法中写
        this("鼠标",9);
    }

    /**
     * 静态代码块：
     * 一般用来初始化静态成员
     * 类加载的时候就被调用
     */


    public Student(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("Student(String,int)");
    }
    {
        System.out.println("构造代码块/实例代码块");
    }
    static{
        classroom = "bit";
        System.out.println("这是个静态代码块!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test {
    public static void main55(String[] args) {
        Student student = new Student("张三",10);
        System.out.println(student);
    }
}
