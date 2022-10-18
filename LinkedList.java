public class LinkedList {
    private Node first;
    public LinkedList() {
        this.first = new Node(-1);
    }
    public Node getFirst() {
        return this.first;
    }
    public void insert(int value) {
        Node new_node = new Node(value);
        Node current_node = this.first;

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
        Node node = this.first;
        while(node.getValue() == 0 && node.getNext() != null) {
            this.first = node.getNext();
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
    public String toString() {
        Node node = this.first;
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
