package myList;

import java.util.Arrays;

public class MyArrayList implements IList{
    public int[] elem;
    public int usedSize;//0
    //顺序表默认大小
     public static final int DEFAULT_SIZE = 10;
    //给数组分配内存
    public MyArrayList(){
        this.elem = new int[DEFAULT_SIZE];
    }

    public MyArrayList(int capacity){
        this.elem = new int[capacity];
    }
    //遍历顺序表中的元素
    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    @Override
    public boolean isFull() {
//        if(usedSize == elem.length){
//            return true;
//        }
//        return false;
        return usedSize == elem.length;
    }

    @Override
    public void add(int data) {
        checkCapacity();
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    @Override
    public void add(int pos, int data) {
        try{
            checkPosOnAdd(pos);
        }catch (PosIlleagaly e){
            e.printStackTrace();
        }
        checkCapacity();
        for (int i = usedSize-1; i >= pos ; i--) {
            elem[i+1] = elem[i];
        }
        elem[pos] = data;
        usedSize++;
    }
    private void checkPosOnAdd(int pos) throws PosIlleagaly{
        if(pos < 0|| pos > usedSize){
            System.out.println("不合法");
            //return;void要return点东西，我们可以抛一个异常
            throw new PosIlleagaly("插入元素下标异常"+pos);
        }
    }
    //检查容量的方法是我们在做功能的时候要包含的，而不是提供给用户使用的
    //只为当前类服务
    private void checkCapacity(){
        if(isFull()){
            //扩容
            elem = Arrays.copyOf(elem, elem.length*2);
        }
    }

    @Override
    public boolean contains(int toFind) {
        if(isEmpty()){
            return false;
        }
        for (int i = 0; i < usedSize; i++) {
            if(elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        return usedSize == 0;
    }


    @Override
    public int indexOf(int toFind) {
        if(isEmpty()){
            return -1;
        }
        for (int i = 0; i < usedSize; i++) {
            if(elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    private void checkPosOnGetAndSet(int pos) throws PosIlleagaly{
        if(pos < 0|| pos >= usedSize){
            System.out.println("不合法");
            throw new PosIlleagaly("获取指定下标的元异常"+pos);
        }
    }

    @Override
    public int get(int pos) throws MyArrayListEmpty{
        checkPosOnGetAndSet(pos);

        if(isEmpty()){
            throw new MyArrayListEmpty("获取下标元素时"+"顺序表为空");
        }
        return elem[pos];
    }

    @Override
    public void set(int pos, int value) {
        checkPosOnGetAndSet(pos);
        elem[pos] = value;
    }

    @Override
    public void remove(int toRemove) {
        int index = indexOf(toRemove);
        if(index == -1){
            System.out.println("没有这个数字");
            return;
        }
        for (int i = index; i < usedSize-1; i++) {
            elem[i] = elem[i+1];
        }
        usedSize--;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void clear() {
        this.usedSize = 0;
    }
}
