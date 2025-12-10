package mylist;

import java.util.Arrays;

public class MyArrayList {

    public int[] elem;
    public int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]);
        }
        System.out.println();
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, elem.length * 2);
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    /**
     * 判断当前的顺序表是不是满的！
     *
     * @return true:满   false代表空
     */
    public boolean isFull() {
        if (usedSize == elem.length) {
            return true;
        }
        return false;
    }


    private boolean checkPosInAdd(int pos) {
        if (pos < 0 || pos > this.usedSize) {
            return false;
        }
        return true;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        try {
            checkPosInAdd(pos);
        } catch (PosIllegaly e) {
            e.printStackTrace();
        }
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < usedSize; i++) {
            if (elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        if(isEmpty()){
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    private void checkPosOnGetAndSet(int pos) throws PosIllegaly {
        if (pos < 0 || pos >= usedSize) {
            System.out.println("不合法");
            throw new PosIllegaly("获取指定下标的元异常" + pos);
        }
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        checkPosOnGetAndSet(pos);
        if (isEmpty()) {
            throw new ArrayEmpty("获取元素下表为" + pos + "顺序表为空");
        }
        return elem[pos];
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        checkPosOnGetAndSet(pos);
        elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(int key) {
        int index = indexOf(key);
        if(index == -1){
            System.out.println("没这个数字");
            return;
        }
        for (int i = index; i < usedSize-1; i++) {
            elem[i] = elem[i+1];
        }
        usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}