public class MyLinkedList implements IList{
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
    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            last = node;
        }else{
            node.next = this.head;
            head.prev = node;
            head = node;
        }
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            last = node;
        }else{
            last.next = node;
            node.prev = head;
            last = node;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        //检查index是否异常
        int len = size();
        if(index < 0 || index > len){
            System.out.println("异常索引"+index);
            return;
        }
        if(index == 0){
            //头插法
            addFirst(data);
            return;
        }
        if(index == len){
            //尾插法
            addLast(data);
            return;
        }

        ListNode cur = findIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    private ListNode findIndex(int index){
        ListNode cur = head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    @Override
    public boolean contains(int key) {
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        ListNode cur = head;
        while(cur != null){
            if(cur.val == key){
                if(cur == head){
                    head = head.next;
                    if(head == null){
                        last = null;
                    }else{
                        head.prev = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next == null){
                        last = last.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                }
                return;
            }else{
                cur = cur.next;
            }
        }
    }

    @Override
    public void removeAllKey(int key) {
        ListNode cur = head;
        while(cur != null){
            if(cur.val == key) {
                if (cur == head) {
                    head = head.next;
                    if (head == null) {
                        last = null;
                    } else {
                        head.prev = null;
                    }
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next == null) {
                        last = last.prev;
                    } else {
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
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
        while(cur!=null){
            ListNode curNext = cur.next;//防止将这个节点的next置为空之后，cur没办法继续遍历
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
    }

    @Override
    public void display() {
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
