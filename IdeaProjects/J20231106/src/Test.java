import binarysearchtree.BinarySearchTree;
import demo1.HashBuck2;

import java.util.*;
class Student {
    public String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class Test {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        //1.统计每个单词出现的频率
        for(String word:words){
            if(map.get(word) == null){
                map.put(word,1);
            }else{
                Integer val = map.get(word);
                map.put(word,val+1);
            }
        }
        //2.建立小根堆
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(new Comparator
                <Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue())==0){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }else{
                Map.Entry<String,Integer> top = minHeap.peek();
                if(top.getValue().compareTo(entry.getValue()) < 0){
                    minHeap.poll();
                    minHeap.offer(entry);
                }else{
                    if(top.getValue().compareTo(entry.getValue()) == 0){
                        if(top.getKey().compareTo(entry.getKey()) > 0){
                            minHeap.poll();
                            minHeap.offer(entry);
                        }
                    }
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String,Integer> top = minHeap.poll();
            ret.add(top.getKey());
        }
        Collections.reverse(ret);
        return ret;































//        HashMap<String,Integer> map = new HashMap<>();
//        for(String word: words){
//            if(map.get(word) == null){
//                map.put(word,1);
//            }else{
//                Integer val = map.get(word);
//                map.put(word,val+1);
//            }
//        }
//        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                if(o1.getValue().compareTo(o2.getValue()) == 0){
//                    return o2.getKey().compareTo(o1.getKey());
//                }
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
//        for(Map.Entry<String,Integer> entry:map.entrySet()){
//            if(minHeap.size() < k){
//                minHeap.offer(entry);
//            }else{
//                Map.Entry<String,Integer> top = minHeap.peek();
//                if(top.getValue().compareTo(entry.getValue()) < 0){
//                    minHeap.poll();
//                    minHeap.offer(entry);
//                }else{
//                    if(top.getValue().compareTo(entry.getValue()) == 0){
//                        if(top.getKey().compareTo(entry.getKey()) > 0){
//                            minHeap.poll();
//                            minHeap.offer(entry);
//                        }
//                    }
//                }
//            }
//        }
//        List<String> ret = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            Map.Entry<String,Integer> top = minHeap.poll();
//            ret.add(top.getKey());
//        }
//        // 2 3 4 --> 4 3 2
//        Collections.reverse(ret);
//        return ret;
    }
    public static void main22(String[] args) {
        int[] array = {1,2,3,3,2};
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        System.out.println(set);
    }
    public static void main9(String[] args) {
        int[] array = {1,2,3,3,2};
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer x : array){
            if(map.get(x) == null){
                //说明是第一次存放
                map.put(x,1);
            }else{
                //遇到重复数字了
                Integer val = map.get(x);
                map.put(x,val+1);
            }
        }
        //遍历整个map
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            System.out.println("key: " + entry.getKey() +
                    " val: " + entry.getValue());
        }
    }
    public static void main7(String[] args) {
        Student student1 = new Student("61012345");
        Student student2 = new Student("61012345");
        HashBuck2<Student,Integer> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(student1,10);
        Integer v = hashBuck2.getValue(student2);
        System.out.println(v);//10
    }
    public static void main4(String[] args) {
        Student student1 = new Student("61012345");
        Student student2 = new Student("61012345");
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
    }

        public static void main6(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("hello",2);
        map.put("abcd",10);
        map.put("gao",3);


        Integer val = map.get("abcd");
        System.out.println(val);

        System.out.println(map);

        for(Map.Entry<String,Integer> entry :map.entrySet()){
            System.out.println("key: "+entry.getKey()+" val: "+entry.getValue());
        }
        //不支持迭代器遍历

        //map可以不需要满足key之间能比较大小
        /*HashMap<Student,Integer> map2 = new HashMap<>();
        map2.put(new Student(),2);//hashcode
        map2.put(new Student(),2);
        map2.put(null,2);*/

        //Set不能存储相同的key  天然可以去重的  底层是一个HashMap 每次存储元素的时候 默认的value其实就是一个Objcet对象
        HashSet<String> set = new HashSet<>();
        set.add("hello");
        set.add("abcd");
        set.add("hello");
        set.add("gaobo");

        System.out.println(set);


    }
    public static void main3(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("sunny");
        set.add("hello");
        set.add("the");
        System.out.println(set);
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    public static void main1(String[] args) {
        Map<String,Integer> map = new TreeMap<>();//二叉搜索树, 查找复杂度O(logN)
        map.put("sunny",5);
        map.put("the",3);
        map.put("is",2);
        map.put("is",21);
        map.put("is",3);
        Set<String> set = map.keySet();
        System.out.println(set);
        System.out.println("===================");
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> entry : entrySet){
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        Map<String,Integer> map1 = new HashMap<>();//哈希表, 查找复杂度O(1) 哈希表-->数组+列表+红黑树
        //通过key获取val值
//        Integer val = map.getOrDefault("the2",9999);
//        System.out.println(val);
    }
    public static void main2(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {5,12,3,2,11,15};
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        System.out.println("sdada");
    }
}
