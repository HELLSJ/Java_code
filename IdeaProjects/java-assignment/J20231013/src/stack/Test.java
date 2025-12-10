package stack;

import java.util.*;

public class Test {
    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    public static void main(String[] args) {
        //队列
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());//1
        System.out.println(queue.poll());//1
        System.out.println(queue.poll());//2
        //链表
        List<Integer> queue1 = new LinkedList<>();

        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
    }
}
