package demo3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}



//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}
//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}
public class Test {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "bit");
        map.put(4, "lambda");
        //不用lambda
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println("key: "+integer+" val: "+s);
            }
        });
        //lambda
        map.forEach((key,val)->System.out.println("key: "+key+" val: "+val));
    }

    public static void main5(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("bit");
        list.add("lambda");
        list.add("hello");
        //不用lambda
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //lambda
        list.forEach(s -> System.out.println(s));
        //不用lambda
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //lambda
        list.sort((o1, o2) -> o1.compareTo(o2));




    }
    public static void main13(String[] args) {
        int a = 10;
        NoParameterNoReturn noParameterNoReturn = ()->{
            System.out.println("捕获变量："+a);
        };
        noParameterNoReturn.test();
    }
    public static void main12(String[] args) {
        //NoParameterReturn noParameterReturn = ()->{return 10;};
        NoParameterReturn noParameterReturn = ()->10;
        System.out.println(noParameterReturn.test());

        OneParameterReturn oneParameterReturn = a->a+10;
        System.out.println(oneParameterReturn.test(1));

        MoreParameterReturn moreParameterReturn = (a,b) -> a+b;
        System.out.println(moreParameterReturn.test(1, 2));
    }
    public static void main2(String[] args) {
        NoParameterNoReturn noParameterNoReturn = ()-> System.out.println("重写test方法");
        noParameterNoReturn.test();

        OneParameterNoReturn oneParameterNoReturn = (a) -> {
            System.out.println("oneParameterNoReturn:" + a);
        };
        oneParameterNoReturn.test(10);

        MoreParameterNoReturn moreParameterNoReturn = (a,b) -> System.out.println(a+b);
        moreParameterNoReturn.test(1,2);

    }
    public static void main1(String[] args) {
        //匿名内部类
        NoParameterNoReturn noParameterNoReturn = new NoParameterNoReturn() {
            @Override
            public void test() {
                System.out.println("重写test方法");
            }
        };
        noParameterNoReturn.test();
    }
}
