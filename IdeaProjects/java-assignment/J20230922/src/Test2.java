/*class MyArray {
    public Object[] array = new Object[10];

    //默认放到数组的最后一个位置
    public void setValue(int pos,Object val) {
        array[pos] = val;
    }

    public Object getValue(int pos) {
        return array[pos];
    }
}*/

import com.sun.org.apache.regexp.internal.RE;

/**
 *
 * @param <T> 当前类是一个泛型类，只是一个占位符
 *
 */
//public T[] array = new T[10];
//默认放到数组的最后一个位置
//public Object[] array = new Object[10];
class MyArray <T> {
    public T[] array = (T[])new Object[10];

    public void setValue(int pos, T val) {
        array[pos] = val;
    }

    public T getValue(int pos) {
        return (T)array[pos];//把返回的类型 强转为指定类型
    }

    public T[] getArray() {
        return array;
    }
}
class Person implements Comparable<Person>{
    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
class Student extends Person{

}
//T一定是Number或者Number的子类
class TestGeneric <T extends Number>{

}
class TestGeneric2 <T extends Person>{

}



//T 一定是实现了Comparable的接口的
class Alg<T extends Comparable<T>>{
    public T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i])< 0){
                max = array[i];
            }
        }
        return max;
    }
}
class Alg2{
    public<T extends Comparable<T>> T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i])< 0){
                max = array[i];
            }
        }
        return max;
    }
}


public class Test2 {
    public static void main(String[] args) {
        Alg2 alg2 = new Alg2();
        Integer[] integers1 = {1,2,3,4,5,6,7};
        //类型推导：根据实参传值来推导此时的类型，所以前面可以不用指定类型
        System.out.println(alg2.findMax(integers1));
        System.out.println("==================");
        Alg<Integer> alg = new Alg<>();
        Integer[] integers = {1,2,3,4,5,6,7};
        Integer ret = alg.findMax(integers);
        System.out.println(ret);
        Alg<Person> alg1 = new Alg<>();

    }
    public static void main3(String[] args) {
        TestGeneric<Number> testGeneric1 = new TestGeneric<>();
        TestGeneric<Integer> testGeneric2 = new TestGeneric<>();
        TestGeneric<Double> testGeneric3 = new TestGeneric<>();
        //TestGeneric2<Number> testGeneric4 = new TestGeneric2<>();
    }
    public static void main2(String[] args) {
        MyArray<Integer> myArray1 = new MyArray<>();
        //[1,  "fdsfa"  ]
        Object[] integers = (Object[]) myArray1.getArray();
    }
    //就是将类型 进行了传递
    public static void main1(String[] args) {
        MyArray<Integer> myArray = new MyArray<Integer>();
        myArray.setValue(0,10);
        myArray.setValue(1,100);

        int a = myArray.getValue(1);

        System.out.println(a);

        MyArray<String> myArray2 = new MyArray<>();
        myArray2.setValue(0,"abcd");
        myArray2.setValue(1,"efg");
        String ret = myArray2.getValue(1);
        System.out.println(ret);
    }
}