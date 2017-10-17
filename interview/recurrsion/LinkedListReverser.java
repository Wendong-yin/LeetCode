package interview.recurrsion;
import interview.recurrsion.LinkedLIstCreator;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListReverser {
    /**
     * Reverse Linked List
     *
     * @param Head of the linkedList that is going to revese
     * @return the head of the Reversed LinkedList
     */
    public static Node reverseLinkedList (Node Head){
        if (Head == null || Head.getNext()==null){
            return Head;
        }
        Node HeadofReversed = reverseLinkedList(Head.getNext());
        Head.getNext().setNext(Head);
        Head.setNext(null);
        return HeadofReversed;
    }

    public static void printList(Node list){
        while (list!=null){
            System.out.print(list.getValue()+" ");
            list = list.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedLIstCreator test = new LinkedLIstCreator();
        Node n0 = test.createLinkedList(new ArrayList<>());
        Node n1 = test.createLinkedList(Arrays.asList(1));
        Node n2 = test.createLinkedList(Arrays.asList(1,2,3,4,5));

        printList(reverseLinkedList(n0));
        printList(reverseLinkedList(n1));
        printList(reverseLinkedList(n2));
    }
}
