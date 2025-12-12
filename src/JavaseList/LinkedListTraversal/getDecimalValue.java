package JavaseList.LinkedListTraversal;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    // Leetcode 1290 https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/description/
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null){
            ans = ans*2 + head.val;
            head = head.next;
        }
        return ans;
    }

    // Leetcode 2058 https://leetcode.cn/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDis = Integer.MAX_VALUE;
        int last = -1;
        int first = -1;
        int i = 1;
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        ListNode a = head;
        ListNode b = head.next;
        ListNode c = head.next.next;
        while (c!=null){
            if ((a.val < b.val && b.val > c.val) ||
                    (a.val > b.val && b.val < c.val)){
                if (first == -1){
                    first = i;
                }
                if(last != -1 && i-last<minDis){
                    minDis = i-last;
                }
                last = i;
            }
            a = b;
            b = c;
            c = c.next;
            i++;
        }
        // 少于两个关键点
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        return new int[]{minDis, last - first};
    }

    // Leetcode 2181 https://leetcode.cn/problems/merge-nodes-in-between-zeros/description/
    //具体算法如下：
    //
    //1. 把 head 当作答案链表的头节点。在一开始，head 也是答案链表的末尾节点 tail。
    //2. 从 head.next 开始遍历链表。
    //3. 如果当前节点的值不为 0，则把节点值加到 tail.val 中。
    //4. 如果当前节点的值等于 0，则更新 tail 为 tail.next，然后把 tail.val 置为 0。由于我们本质上是在合并节点值，tail.next 这个节点是一定存在的。
    //5. 继续向后遍历链表。
    //6. 如果当前节点的下一个节点为空，说明我们遍历到了链表的最后一个节点 0，遍历结束。否则回到第 3 步。
    //7. 由于我们是在原链表上修改的，原链表的最后一个节点 0 必然不在答案链表中，所以答案链表一定比原链表短。把 tail.next 置为空，以确保答案链表不包含原链表中多余的节点。
    //8. 最后返回 head，即答案链表的头节点。

    public ListNode mergeNodes(ListNode head) {
        ListNode tail = head;
        for (ListNode cur = head.next; cur.next != null; cur = cur.next){
            if (cur.val != 0){
                tail.val += cur.val;
            }else{
                tail = tail.next;
                tail.val = 0;
            }
        }
        tail.next = null;
        return head;
    }
}