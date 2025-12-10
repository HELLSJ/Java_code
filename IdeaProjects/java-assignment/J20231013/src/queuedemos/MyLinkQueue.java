package queuedemos;

import java.util.List;

public class MyLinkQueue {
    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode prev;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode last;
    public int usedSize;
    public boolean offer(int val){
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
            last = node;
        }else{
            last.next = node;
            node.prev = last;
            last = last.next;
        }
        usedSize++;
        return true;
    }
    public int poll(){
        //没有节点
        if(head == null){
            return -1;
        }
        int retVal = head.val;
        //只有一个节点
        if(head.next == null){
            head = null;
            last = null;
            return retVal;
        }
        //两个及以上的节点
        head = head.next;
        head.prev = null;
        usedSize--;
        return retVal;
    }

    public int peek(){
        if(head == null){
            return -1;
        }
        return head.val;
    }

    public boolean empty(){
        return head == null;
    }

    public int size(){
        return usedSize;
    }
}

