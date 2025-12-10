package demo1;

import java.util.Arrays;

public class HashBuck {
    static class Node{
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public Node[] array;
    public int usedSize;//记录存放的有效数据
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    public HashBuck(){
        array = new Node[10];
    }
    public void put(int key, int val){
        int index = key % array.length;
        //遍历index下标的链表是否存在key，如果存在就更新value，不存在就插入数据
        Node cur = array[index];
        while(cur!=null){
            if(cur.key == key){
                //更新value
                cur.val = val;
            }
            cur = cur.next;
        }
        //cur==null-->遍历完没有找到key
        // 头插法
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        usedSize++;
//        //尾插法
//        Node node = new Node(key,val);
//        array[index].next = node;
//        usedSize++;
        if(doLoadFactor()>DEFAULT_LOAD_FACTOR){
            //扩容
            //array = Arrays.copyOf(array, 2*array.length);
            resize();
        }
    }
    private void resize(){
        Node[] newArray = new Node[2* array.length];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            //遍历每个数组元素（链表）
            while(cur != null){
                Node tmp = cur.next;
                int newIndex = cur.key % newArray.length;
                //采用头插法 插入到新数组newIndex下标
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = tmp;
            }
        }
        array = newArray;
    }
    private float doLoadFactor(){
        return usedSize * 1.0f / array.length;
    }

    public int get(int key){
        int index = key % array.length;
        Node cur = array[index];
        while(cur != null){
            if(cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}
