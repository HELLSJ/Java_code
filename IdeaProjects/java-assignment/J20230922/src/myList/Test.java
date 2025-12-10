package myList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> list3 = new ArrayList<>();
        list3.add(new ArrayList<>());
        list3.add(new ArrayList<>());
    }
    public static void main33(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
//for-each
        for(Integer x: list){
            System.out.print(x+"");
        }
        System.out.println();
//迭代器
        Iterator<Integer> it= list.iterator();
        while(it.hasNext()){
            System.out.println(it.next()+" ");
        }


//        List<Integer> list1 = list.subList(1,3);
//        System.out.println(list1);
//        System.out.println("===========");
//        list1.set(0, 99);
//        System.out.println(list1);
//        System.out.println(list);
    }
    public static void main12(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"");
        }
        System.out.println();

        ArrayList<Number> list2 = new ArrayList<>(list);

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Number> list12 = new ArrayList<>(list1);
    }
    public static void main1(String[] args) {
        MyArrayList  myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(1,199);
        myArrayList.display();
        System.out.println(myArrayList.contains(199));
        myArrayList.set(2,8888);
        myArrayList.display();
    }
}
