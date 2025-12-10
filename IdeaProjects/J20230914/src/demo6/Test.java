package demo6;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author 12629
 * @Description：
 */
class Student implements Comparable<Student> {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        //System.out.println("===fdsfsafdsafdsafdsafdsafdsafsafdsafa");
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
//比较器
class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.age - o1.age ;
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        //String  自己重写的 compareTo 方法
        return o1.name.compareTo(o2.name);
    }
}



public class Test {


    public static void bubbleSort(Comparable[] comparables) {

        for (int i = 0; i < comparables.length-1; i++) {
            for (int j = 0; j < comparables.length-1-i; j++) {

                if(comparables[j].compareTo(comparables[j+1]) > 0) {
                    Comparable tmp = comparables[j];
                    comparables[j] = comparables[j+1];
                    comparables[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("zhangsan",10);
        students[1] = new Student("lisi",4);
        students[2] = new Student("abc",5);
        System.out.println("排序前： "+Arrays.toString(students));

        //bubbleSort(students);
        Arrays.sort(students);

        System.out.println("排序后： "+Arrays.toString(students));
    }


    public static void main3(String[] args) {
       /* int[] array = {1,2,31,14};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        */

        Student[] students = new Student[3];
        students[0] = new Student("zhangsan",10);
        students[1] = new Student("lisi",4);
        students[2] = new Student("abc",5);
        System.out.println("排序前： "+Arrays.toString(students));

        AgeComparator ageComparator = new AgeComparator();
        NameComparator nameComparator = new NameComparator();

        Arrays.sort(students);

        System.out.println("排序后： "+Arrays.toString(students));

    }

    public static void main2(String[] args) {
        Student student1 = new Student("zhangsan",10);
        Student student2 = new Student("lisi",4);


        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student1, student2));


        NameComparator nameComparator = new NameComparator();
        System.out.println(nameComparator.compare(student1, student2));


        //System.out.println(student1 > student2);

        //System.out.println(student1.compareTo(student2));
    }


    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a > b);

    }
}