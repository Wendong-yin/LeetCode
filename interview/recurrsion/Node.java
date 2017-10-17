package interview.recurrsion;

public class Node {

    private final int value;
    //防止用户添加数据后修改，所以只有 getter，没有 setter。
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
        //这样创建出来的 node 很“干净”；
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
