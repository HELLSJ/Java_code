package JavaseList.reverseLink;

// https://leetcode.cn/problems/reverse-linked-list/
// 简单理解：比如链表为 1→2→3。创建一个新的空链表，然后用头插法依次把节点 1,2,3 插到这个新链表的头部，就得到了链表 3→2→1，这正是反转后的链表。
//
//头插法的意思是，把一个节点 node 指向链表头节点（node.next 更新为链表头节点），那么 node 就插在了链表的左侧，新链表的头节点为 node。
//
//对于链表 1→2→3，结合代码来说，顺序为：
//第一轮循环结束后，得到链表 1。
//第二轮循环结束后，得到链表 2→1。
//第三轮循环结束后，得到链表 3→2→1。

class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
