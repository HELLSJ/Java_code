import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
class Student{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Imp implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
public class Test {

    public static int[] smallestK(int[] array, int k) {
        int[] ret = new int[k];
        if(array == null || k <= 0) {
            return ret;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        //1、建立大小为k的大根堆 O(K*logK)
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(array[i]);
        }

        //2、遍历剩下的元素 (N-K)*logK
        // (K*logK) + N*logK  - K*logK   =   N*logK
        for (int i = k; i < array.length; i++) {
            int top = priorityQueue.peek();//27
            if(array[i] < top) {
                priorityQueue.poll();
                priorityQueue.offer(array[i]);
            }
        }
        //下面这个不能算topK的复杂度 这个地方是整理数据
        //k*logK
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] array = {1,3,15,7,19,10};

        //向上调整 O(logN)
        for (int i = 0; i < array.length; i++) {
            priorityQueue.offer(array[i]);
        }
        int k = 3;
        int[] ret = new int[k];
        //k*logN
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        System.out.println(Arrays.toString(ret));
    }
    public static void main2(String[] args) {
        //当我们实例化一个PriorityQueue对象之后，其实默认是一个小根堆
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.offer(10);
//        priorityQueue.offer(5);
//        priorityQueue.offer(6);
//        System.out.println(priorityQueue.poll());//5
//        System.out.println(priorityQueue.poll());//6

        PriorityQueue<Student> priorityQueue1 = new PriorityQueue<>();
        priorityQueue1.offer(null);
//        priorityQueue1.offer(new Student("lisi",12));
    }
    public static void main1(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.initElem(array);

        testHeap.createHeap();

        //testHeap.push(80);
        testHeap.pop();
        System.out.println();
    }
}
