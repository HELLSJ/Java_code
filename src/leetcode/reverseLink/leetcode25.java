package leetcode.reverseLink;
// https://leetcode.cn/problems/reverse-nodes-in-k-group/description/

//K个节点为一组，反转这一组节点
//反转后有三段链表：前段(pre)、反转段、后段(p0.next)
//用个nxt存储p0下一个节点，然后通过 p0.next.next 和 p0.next 完成三段重新拼接，然后将 p0 移动到下一段起点(p0=next)，循环继续
//不足 k 个的直接退出循环，不翻转
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计节点个数
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;

        // k 个一组处理
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; i++) { // 同 92 题
                ListNode nxt = cur.next;
                cur.next = pre; // 每次循环只修改一个 next，方便大家理解
                pre = cur;
                cur = nxt;
            }

            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }
}