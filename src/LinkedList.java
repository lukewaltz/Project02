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
    public static LinkedList split(int num) {
        LinkedList list = new LinkedList();
        char[] str_num = (String.valueOf(num)).toCharArray();
        for (char ch : str_num) {
            int val = Integer.parseInt(String.valueOf(ch));
            list.insertFront(val);
        }
        return list;
    }

    public int listToInt() {
        int res = 0;
        int place = 1;
        Node current = this.head;
        while(current != null) {
            res += current.getValue() * place;
            place *= 10;
            current = current.getNext();
        }
        return res;
    }

    public int add(int num1, int num2) {
        LinkedList l1 = split(num1);
        LinkedList l2 = split(num2);

        LinkedList result = new LinkedList();
        Node cur1 = l1.head;
        Node cur2 = l2.head;
        helper_add(result, cur1, cur2, new Node(0));

        return result.listToInt();
    }

    public void helper_add(LinkedList result, Node n1, Node n2, Node carry) {
        if (n1 == null & n2 != null) {
            LinkedList ans = split(n2.getValue() + carry.getValue());
            if (ans.length() > 1) {
                result.append(ans.head.getValue());
                Node carry_node = ans.head.getNext();
                helper_add(result, null, n2.getNext(), carry_node);
            } else if (ans.length() == 1) {
                result.append(ans.head.getValue());
                Node carry_node = new Node(0);
                helper_add(result, null, n2.getNext(), carry_node);
            }
        }
        else if (n1 != null & n2 == null) {
            LinkedList ans = split(n1.getValue() + carry.getValue());
            if (ans.length() > 1) {
                result.append(ans.head.getValue());
                Node carry_node = ans.head.getNext();
                helper_add(result, n1.getNext(), null, carry_node);
            } else if (ans.length() == 1) {
                result.append(ans.head.getValue());
                Node carry_node = new Node(0);
                helper_add(result, n1.getNext(), null, carry_node);
            }
        }
        else if (n1 != null & n2 != null) {
            LinkedList ans = split(n1.getValue() + n2.getValue() + carry.getValue());
            if (ans.length() > 1) {
                result.append(ans.head.getValue());
                Node carry_node = ans.head.getNext();
                helper_add(result, n1.getNext(), n2.getNext(), carry_node);
            } else if (ans.length() == 1) {
                result.append(ans.head.getValue());
                Node carry_node = new Node(0);
                helper_add(result, n1.getNext(), n2.getNext(), carry_node);
            }
        }
        else {
            if (carry.getValue() != 0) {
                result.append(carry.getValue());
            }
        }
    }

    public int multiply(int num1, int num2) {
        if (num2 > num1) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        LinkedList l1 = split(num1);
        LinkedList l2 = split(num2);

        LinkedList result = new LinkedList();
        result.append(0);
        LinkedList current = new LinkedList();
        Node cur1 = l1.head;
        Node cur2 = l2.head;
        Node carry = new Node(0);
        int num_zero = 0;

        while (cur2 != null) {
            if (cur1 != null) {
                LinkedList prod = split((cur1.getValue() * cur2.getValue()) + carry.getValue());
                if (prod.length() > 1) {
                    current.append(prod.head.getValue());
                    carry = prod.head.getNext();
                    cur1 = cur1.getNext();
                }
                else if (prod.length() == 1) {
                    current.append(prod.head.getValue());
                    carry = new Node(0);
                    cur1 = cur1.getNext();
                }
            }
            else {
                if (carry.getValue() != 0) {
                    current.append(carry.getValue());
                }
                cur2 = cur2.getNext();
                cur1 = l1.head;
                result = split(result.add(result.listToInt(), current.listToInt()));
                current = new LinkedList();
                num_zero += 1;
                int i = num_zero;
                while (i != 0) {
                    current.append(0);
                    i--;
                }
            }
        }
        return result.listToInt();
    }

    public int exponent(int x, int n) {
        LinkedList result = new LinkedList();
        int res = 1;
        int x2 = x*x;
        if (n % 2 == 0) {
            int i = n / 2;
            while (i != 0) {
                res = result.multiply(x2, res);
                i--;
            }
        }
        else {
            int i = (n-1) / 2;
            while (i != 0) {
                res = result.multiply(x2, res);
                i--;
            }
            res *= x;
        }
        return res;
    }


    public String toString() {
        String resultStr = "";
        Node currentNode = this.head;
        while (currentNode != null) {
            resultStr = currentNode.getValue() + resultStr;
            currentNode = currentNode.getNext();
        }
        resultStr = resultStr + resultStr;
        return resultStr.substring(0, resultStr.length() - this.length());
    }
}
