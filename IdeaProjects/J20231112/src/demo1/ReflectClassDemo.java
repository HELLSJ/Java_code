package demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 12629
 * @Description：
 */
public class ReflectClassDemo {
    public static void reflectNewInstance() {
        Class<?> classStudent = null;
        try {
            classStudent = Class.forName("demo1.Student");
            Student student = (Student)classStudent.newInstance();
            System.out.println(student);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
            //newInstance 是受查异常，要加多这一行进行排查
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static void reflectPrivateConstructor() {
        Class<?> classStudent = null;
        try {
            classStudent = Class.forName("demo1.Student");
            //获得构造方法
            Constructor<?> constructor = classStudent.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);
            Student student = (Student)constructor.newInstance("xiaoming",15);
            System.out.println(student);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
            //newInstance 是受查异常，要加多这两行进行排查
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reflectPrivateField() {
        Class<?> classStudent = null;
        try {
            classStudent = Class.forName("demo1.Student");
            Field field = classStudent.getDeclaredField("name");
            field.setAccessible(true);
            Student student = (Student)classStudent.newInstance();

            field.set(student,"caocao");

            System.out.println(student);


        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public static void reflectPrivateMethod() {
        Class<?> classStudent = null;
        try {
            classStudent = Class.forName("demo1.Student");
            Method method = classStudent.getDeclaredMethod("function",String.class);
            method.setAccessible(true);
            Student student = (Student)classStudent.newInstance();
            method.invoke(student,"我是一个反射的参数！");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
//        reflectNewInstance();
        reflectPrivateConstructor();
//        reflectPrivateField();
//        reflectPrivateMethod();
    }
}