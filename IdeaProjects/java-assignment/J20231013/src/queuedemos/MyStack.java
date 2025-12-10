package queuedemos;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x) {
        if(!qu1.isEmpty()){
            qu1.offer(x);
        }else if(!qu2.isEmpty()){
            qu2.offer(x);
        }else{
            //两个队列都是空的，指定放到qu1里面
            qu1.offer(x);
        }
    }

    public int pop() {
        if(empty()){
            return -1;
        }
        if(!qu1.isEmpty()){
            int size1 = qu1.size();//让一个size1记录qu1的大小，防止循环的时候循环条件里的size没有变化
            for (int i = 0; i < size1-1; i++) {
                int x = qu1.poll();
                qu2.offer(x);
            }
            return qu1.poll();
        }else{
            int size2 = qu2.size();
            for (int i = 0; i < size2-1; i++) {
                int x = qu2.poll();
                qu1.offer(x);
            }
            return qu2.poll();
        }
    }

    public int top() {
        if(empty()){
            return -1;
        }
        if(!qu1.isEmpty()){
            int size1 = qu1.size();
            int x = -1;
            for (int i = 0; i < size1; i++) {
                x = qu1.poll();
                qu2.offer(x);
            }
            return x;
        }else{
            int x = -1;
            int size2 = qu2.size();
            for (int i = 0; i < size2; i++) {
                x = qu2.poll();
                qu1.offer(x);
            }
            return x;
        }
    }

    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}
