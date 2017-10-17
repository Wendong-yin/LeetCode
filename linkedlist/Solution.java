package linkedlist;


public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

    public static ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1; l1 = l1.next;
            }
            else {
                p.next = l2; l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next=new ListNode(5);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(2);
        l2.next=new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(8);

        Aux.printNode(l1);
        Aux.printNode(l2);

        ListNode l3 = mergeTwoLists_2(l1 ,l2);
        Aux.printNode(l3);

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Aux{
    public static void printNode(ListNode list){
        while(list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }
}