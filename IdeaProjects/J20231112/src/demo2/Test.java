package demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void func() throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException {
        //反射Enum类
        Class<?> c1 = Class.forName("demo2.TestEnum");
        //获取Enum类里面私有变量的类型
        Constructor<?> constructor = c1.getDeclaredConstructor(String.class,int.class,int.class, String.class);
        constructor.setAccessible(true);//私有的要设置true，允许获取
        //实例化新对象
        TestEnum testEnum = (TestEnum) constructor.newInstance("白色",9,6,"棕色");
        System.out.println(testEnum);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException {
        func();
    }
}
