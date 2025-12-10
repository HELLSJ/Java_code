package stack;

import java.util.Arrays;

public class MyStack implements IStack{
    private int[] elem;
    private int usedSize;
    private static final int DEFAULT_CAPACITY = 10;
    public MyStack(){
        elem = new int[DEFAULT_CAPACITY];
    }
    @Override
    public void push(int x) {
        if (full()){
            elem = Arrays.copyOf(elem, 2* elem.length);
        }
        elem[usedSize] = x;
        usedSize++;
    }

    @Override
    public int pop() {
        if(empty()){
            throw new EmptyException("栈空了！");
        }
        int old = elem[usedSize-1];
        usedSize--;//相当于删除元素
        return old;
    }

    @Override
    public int peek() {
        return elem[usedSize-1];
    }

    @Override
    public int size() {
        return usedSize;
    }

    @Override
    public boolean empty() {
        return usedSize == 0;
    }

    @Override
    public boolean full() {
        if(usedSize == elem.length){
            return true;
        }
        return false;
    }


}
