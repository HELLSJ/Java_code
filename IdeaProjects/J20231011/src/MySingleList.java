import static java.lang.Math.abs;

public class MySingleList implements IList{



    //节点的内部类
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode head;
    //public int usedSize;//可以定义

    public void createList() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(34);
        ListNode node4 = new ListNode(45);
        ListNode node5 = new ListNode(56);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        this.head = node1;
    }

    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {

        ListNode node = new ListNode(data);

        ListNode cur = this.head;
        if(this.head == null) {
            this.head = node;
        }else {
            //找到尾巴
            while(cur.next != null) {
                cur = cur.next;
            }
            //cur 现在指向了最后一个节点
            cur.next = node;
        }

    }

    @Override
    public void addIndex(int index, int data) {
        if(index < 0 || index > size()) {
            //抛自定义的异常
            return;
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = searchPrev(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
    }

    private ListNode searchPrev(int index) {
        ListNode cur = this.head;
        int count = 0;
        while (count != index-1 ) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    @Override
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if(this.head == null) {
            //一个节点都没有 无法删除！
            return;
        }
        if(this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        //1. 找到前驱
        ListNode cur = findPrev(key);
        //2、判断返回值是否为空？
        if(cur == null) {
            System.out.println("没有你要删除的数字");
            return;
        }
        //3、删除
        ListNode del = cur.next;
        cur.next = del.next;


    }

    /**
     * 找到关键字key的前一个节点的地址
     * @param key
     * @return
     */
    private ListNode findPrev(int key) {
        ListNode cur = this.head;
        while (cur.next != null) {
            if(cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {
        if(this.head == null) {
            return;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == key) {
            head = head.next;
        }
    }

    @Override
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void clear() {
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            //cur.val = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;
    }

    @Override
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }


    /**
     * 这个是从指定位置开始打印
     * @param newHead
     */
    public void display(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public ListNode reverseList() {
        if(head == null) {
            return null;
        }
        //只有一个节点
        if(head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }


    public ListNode middleNode(){
        int len = size();
        ListNode cur = head;
        for (int i = 0; i < len/2; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public ListNode middleNode2(){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k <= 0 || head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while(k-1!=count){
            fast = fast.next;
            if(fast == null){
                return null;
            }
            count++;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean chkPalindrome() {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        //1.找到中间位置
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.翻转
        ListNode cur = slow.next;
        while(cur!=null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3.从前到后  从后到前
        while(head!=slow){
            //顺序不能换，一定得在值相等的情况下才来判断next
            if(head.val != slow.val){
                return false;
            }
            if(head.next == slow){
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        //求长度
        while (cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }
        cur1 = headA;
        cur2 = headB;
        int len3 = len1-len2;
        if(len3<0){
            //修正一下cur1和cur2的指向
            cur1 = headB;
            cur2 = headA;
            len3 = len2-len1;
        }
        //cur1一定指向最长的链表，cur2一定指向最短的链表
        //len3一定是一个正数
        //2.走差值步
        while(len3 != 0){
            cur1 = cur1.next;
            len3--;
        }
        //3.同时走 --> 4.相遇
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}


