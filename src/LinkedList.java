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

    public int length() {
        int count = 0;
        Node current = this.head;
        while (current != null) {
            count ++;
            current = current.getNext();
        }
        return count;
    }

    public void insertFront(int value) {
        Node newNode = new Node(value);
        if (this.head.getValue() == -1) {
            this.head = newNode;
        }
        else {
            newNode.setNext(this.head);
            this.head = newNode;
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
            int val = Integer.parseInt(String.valueOf(ch));
            list.insertFront(val);
        }
        return list;
    }

    public Node carry(LinkedList list) {
        if (list.getHead().getNext() == null) {
            Node node = new Node(0);
            return node;
        }
            return list.getHead().getNext();
        }


    public int add(int num1, int num2){
        LinkedList l1 = split(num1);
        LinkedList l2 = split(num2);
        Node cur1 = l1.head;
        Node cur2 = l2.head;
        //int carryVal = 0;
        int sum = 0;
        while(cur1 != null | cur2 != null){
            Node carryNode = carry(split(sum));
            int carryVal = carryNode.getValue();
            //int sum = 0;
            if (cur1 == null){
                sum = cur2.getValue() + carryVal;
                carryVal = 0;
            }
            else if(cur2 == null){
                sum = cur1.getValue() + carryVal;
                carryVal = 0;
            } else {
                int cur1val = cur1.getValue() + carryVal;
                int cur2val = cur2.getValue();
                sum = cur1val + cur2val;
                if(sum > 9){
                    LinkedList sumLst = split(sum);
                }
            }
            LinkedList sumLst = split(sum);

        }
        return sum;
    }

    public String toString() {
        Node node = this.head;
        String result = "LinkedList: ";
        while (node != null) {
            if (node.getNext() == null) {
                result += node.getValue();
            }
            else {
                result += node.getValue() + ", ";
            }
            node = node.getNext();
        }
        return result;
    }
}
