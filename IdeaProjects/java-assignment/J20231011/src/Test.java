public class Test {
    public static MySingleList.ListNode mergeTwoLists(MySingleList.ListNode head1, MySingleList.ListNode head2){
        MySingleList.ListNode newH = new MySingleList.ListNode(-1);
        MySingleList.ListNode tmpH = newH;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                tmpH.next = head1;
                head1 = head1.next;
            }else{
                tmpH.next = head2;
                head2 = head2.next;
            }
            tmpH = tmpH.next;
        }
        //可能会有一个链表先走完，如果head1先空了，那就再head2里面走
        if(head1!=null){
            tmpH.next = head1;
        }
        if(head2!=null){
            tmpH.next = head2;
        }
        return newH.next;
    }
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();

        mySingleList.addLast(12);
        mySingleList.addLast(23);
        mySingleList.addLast(34);
        mySingleList.addLast(45);
        mySingleList.addLast(56);
        mySingleList.addLast(67);

        mySingleList.display();

        MySingleList mySingleList2 = new MySingleList();

        mySingleList2.addLast(12);
        mySingleList2.addLast(23);
        mySingleList2.addLast(28);
        mySingleList2.addLast(29);
        mySingleList2.addLast(30);
        mySingleList2.addLast(167);

        mySingleList2.display();



    }
}
