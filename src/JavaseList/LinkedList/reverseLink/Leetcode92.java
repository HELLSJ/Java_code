package JavaseList.reverseLink;
// https://leetcode.cn/problems/reverse-linked-list-ii/description/

//1->2->3->4->5 翻转 2->3->4 为 4->3->2
//1. 用 dummy 处理头节点可能被反转的情况 0(dummy)->1->2->3->4->5
//2. 找到 left 前一个节点 p0 (1)
//3. 从 p0.next 开始反转 right-left+1 个节点（标准链表反转）
//4. pre 是反转后的新头(4)，p0.next 是反转后的尾(2)
//5. p0.next(2).next = cur(5) 把尾连上后段，此时cur走到反转链表区间最后一个节点的next位置了，就是5
//6. p0.next = pre(4) 把前段连上反转段


class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode p0 = dummy;
        for(int i = 0;i<left-1;i++){
            p0 = p0.next;
        }

        ListNode pre = null;
        ListNode cur = p0.next;

        for (int i=0; i<right-left+1; i++){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }
}