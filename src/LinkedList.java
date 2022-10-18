import java.util.concurrent.LinkedBlockingDeque;

public class LinkedList {
    private Node head;
    public LinkedList() {
        this.head = new Node(-1);
    }
    public Node getHead() {
        return this.head;
    }
    public void append(int value) {
        Node new_node = new Node(value);
        Node current_node = this.head;

        if (current_node.getValue() == -1) {
            current_node.setValue(new_node.getValue());
            current_node.setNext(new_node.getNext());
        }
        else {
            while (current_node.getNext() != null) {
                current_node = current_node.getNext();
            }
            current_node.setNext(new_node);
        }
    }
    public void check_and_delete_zeros() {
        Node node = this.head;
        while(node.getValue() == 0 && node.getNext() != null) {
            this.head = node.getNext();
            node = node.getNext();
        }
    }
    /*
    public void printList() {
        Node node = this.first;
        while (node != null) {
            System.out.print(node.getValue() + ", ");
            node = node.getNext();
        }
    }
    */

    public LinkedList split(int num) {
        LinkedList list = new LinkedList();
        char[] str_num = (String.valueOf(num)).toCharArray();
        for (char ch : str_num) {
            num = (int) ch;
            list.append(num);
        }
        return list;
    }
    
    public Node carry(int ans, int car) {
        Node node = new Node(ans + car);
        return node;
    }

    public String toString() {
        Node node = this.head;
        String result = "LinkedList: ";
        while (node != null) {
            if (node.getNext() == null) {
                result += node.getValue();
                node = node.getNext();
            }
            else {
                result += node.getValue() + ", ";
                node = node.getNext();
            }
        }
        return result;
    }
}
