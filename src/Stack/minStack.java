package Stack;

import java.util.Stack;

class MinStack {

    //我们可以申请两个栈，一个栈就是普通的栈，用来放列表的元素的
    //另一个栈就是最小栈，每次放入普通栈的元素都要和原来栈里面的元素进行比较，如果是最小的话就放入最小栈，放到最后你会发现，最小栈的栈顶就是那个最小值
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.empty()){
            minStack.push(val);
        }else{
            int peekVal = minStack.peek();
            if(val<=peekVal){
                minStack.push(val);
            }
        }
    }
    // 1.要pop的元素和栈顶元素比较
    // 2.如果pop的元素和栈顶元素是一样的，那么两个栈都要出
    // 3.不一样只出普通栈
    public void pop() {
        int val = stack.pop();
        if(!minStack.empty()){
            if(val==minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(!minStack.empty()){
            return minStack.peek();
        }
        return -1;
    }
}