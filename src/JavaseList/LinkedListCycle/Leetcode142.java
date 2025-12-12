// https://leetcode.cn/problems/linked-list-cycle-ii/description/
package JavaseList.LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

class Solution1{
    // 方法1：依旧哈希表
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) {
                return head;
            }
            seen.add(head);
            head = head.next;
        }
        return null;
    }
    /**
     * 方法 2：快慢指针（Floyd 判圈算法）
     *
     * 使用两个指针 fast 和 slow，它们起始都位于链表头部。
     * slow 指针每次向后移动一步，而 fast 指针每次移动两步。
     * 如果链表中存在环，则 fast 指针最终会在环中再次与 slow 指针相遇。
     *
     * 假设链表中环外部分长度为 a。slow 进入环后，又走了 b 的距离与 fast 相遇。
     * 此时 fast 已经在环内走了 n 圈，因此 fast 总共走过的距离为：
     *
     *   a + n(b + c) + b = a + (n + 1)b + nc
     *
     * 根据题意，fast 的步数始终是 slow 的 2 倍，因此有：
     *
     *   a + (n + 1)b + nc = 2(a + b)
     *
     * 化简得：
     *
     *   a = c + (n - 1)(b + c)
     *
     * 由此可知：从“相遇点”到“环的入口”的距离 c，加上 n - 1 圈的环长，
     * 等于从链表头部到入口点的距离 a。
     *
     * 其中的 (n - 1)(b + c) 表示 slow 在环内多绕的圈数。
     *
     * 因此，当 slow 与 fast 第一次相遇后，
     * 我们再创建第三个指针 ptr 指向链表头部。
     * ptr 与 slow 每次都前进一步。
     * 最终当 ptr == slow 时，它们相遇的节点就是环的入口。
     */

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 第一步：寻找相遇点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {  // 相遇
                break;
            }
        }

        // 如果 fast 到达 null，说明没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        // 第二步：从 head 和 slow 同时走，相遇点即入环点
        ListNode ptr = head;
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }

        return ptr;
    }
}

