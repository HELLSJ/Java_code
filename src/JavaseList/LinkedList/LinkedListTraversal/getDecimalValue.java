package JavaseList.LinkedListTraversal;


import java.util.HashSet;
import java.util.Set;

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

    // leetcode 817 https://leetcode.cn/problems/linked-list-components/solutions/1883654/lian-biao-zu-jian-by-leetcode-solution-5f91/
    // 此题需要计算组件的个数，只需在链表中计算有多少组件的起始位置即可。当一个节点满足以下条件之一时，它是组件的起始位置：
    // 节点的值在数组 nums 中且节点位于链表起始位置；
    // 节点的值在数组 nums 中且节点的前一个点不在数组 nums 中。
    // 遍历链表，计算出满足条件的点的个数即可。因为需要多次判断值是否位于数组 nums 中，用一个哈希集合保存数组 nums 中的点可以降低时间复杂度。
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for(int num:nums){
            numsSet.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null){
            if (numsSet.contains(head.val)){
                if(!inSet){
                    inSet = true;
                    res++;
                }
            }else{
                inSet = false;
            }
            head = head.next;
        }
        return res;
    }
}