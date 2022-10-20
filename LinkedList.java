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
    public void sum(Node n1, Node n2, Node carry) {
    }

    public static LinkedList split(int num) {
        LinkedList list = new LinkedList();
        char[] str_num = (String.valueOf(num)).toCharArray();
        for (char ch : str_num) {
            int val = Integer.parseInt(String.valueOf(ch));
            list.insertFront(val);
        }
        return list;
    }

    public LinkedList add(int num1, int num2) {
        LinkedList l1 = split(num1);
        LinkedList l2 = split(num2);

        LinkedList result = new LinkedList();
        Node cur1 = l1.head;
        Node cur2 = l2.head;
        helper_add(result, cur1, cur2, new Node(0));
        return result;
    }
    
    public void helper_add(LinkedList result, Node n1, Node n2, Node carry) {
        if (n1 == null & n2 != null) {
            LinkedList ans = split(n2.getValue() + carry.getValue());
            if (ans.length() > 1) {
                result.insertFront(ans.head.getValue());
                Node carry_node = ans.head.getNext();
                helper_add(result, null, n2.getNext(), carry_node);
            } else if (ans.length() == 1) {
                result.insertFront(ans.head.getValue());
                Node carry_node = new Node(0);
                helper_add(result, null, n2.getNext(), carry_node);
            }
        }
        else if (n1 != null & n2 == null) {
            LinkedList ans = split(n1.getValue() + carry.getValue());
            if (ans.length() > 1) {
                result.insertFront(ans.head.getValue());
                Node carry_node = ans.head.getNext();
                helper_add(result, n1.getNext(), null, carry_node);
            } else if (ans.length() == 1) {
                result.insertFront(ans.head.getValue());
                Node carry_node = new Node(0);
                helper_add(result, n1.getNext(), null, carry_node);
            }
        }
        else if (n1 != null & n2 != null) {
            LinkedList ans = split(n1.getValue() + n2.getValue() + carry.getValue());
            if (ans.length() > 1) {
                result.insertFront(ans.head.getValue());
                Node carry_node = ans.head.getNext();
                helper_add(result, n1.getNext(), n2.getNext(), carry_node);
            } else if (ans.length() == 1) {
                result.insertFront(ans.head.getValue());
                Node carry_node = new Node(0);
                helper_add(result, n1.getNext(), n2.getNext(), carry_node);
            }
        }
        else {
            if (carry.getValue() != 0) {
                result.insertFront(carry.getValue());
            }
        }
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
