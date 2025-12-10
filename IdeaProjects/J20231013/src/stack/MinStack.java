package stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        //普通栈放元素
        stack.push(val);
        //最小栈空不空
        if(minStack.empty()){
            minStack.push(val);
        }else{
            //判断要存放的元素是否小于栈顶元素
            int peekVal = minStack.peek();
            if(val<peekVal){
                minStack.push(val);
            }
        }
    }

    public void pop() {
        int val = stack.pop();
        if(!minStack.empty()){
            if(val == minStack.peek()){
                minStack.pop();
            }
        }
    }
    //peek获取当前普通栈的栈顶元素
    public int top() {
        return stack.peek();
    }
    //最小栈的peek，通过这个方法获取最小值
    public int getMin() {
        if(!minStack.empty()){
            return minStack.peek();
        }
        return -1;
    }
}
