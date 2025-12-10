import java.util.List;
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
}
