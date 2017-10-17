package interview.recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedLIstCreator {

    /**
     * Create a linked list
     *
     * @param data the data to create in the list
     * @return the head of the linked list. The returned linked list
     * ends with last node with getNext()==null;
     */
    public Node createLinkedList(List<Integer> data){
        if (data.isEmpty()){
            return null;
            //添加data为0的情况，同时也是递归的出口。也是数学归纳法的基本条件。
            //注意返回不能随便的返回也要按照之前的要求，如果程序功能正常，应该返回什么值呢？
            //应该返回一个头结点，如果没有，则是null;
        }
        Node firstNode = new Node(data.get(0));
        //在写递归的时候，先考虑一般情况，暂时先不考虑 data 为空的情况。

        Node headOfSubList = createLinkedList(data.subList(1,data.size()));
        //【1】拆分：通过 sublist 拆分：去掉第一个元素后的所有元素
        //在写这个递归的时候，假定之前的程序功能正常：1. 返回头结点 2. 末尾节点指向 null
        //【2】然后用什么来接受这个返回值？ 因为返回一个头结点，所以用另外一个节点来接这个返回值

        firstNode.setNext(headOfSubList);
        //【3】再把两个头结点连接
        return firstNode;

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

        printList(n0);
        printList(n1);
        printList(n2);

    }
}
