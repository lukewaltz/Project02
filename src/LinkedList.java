import org.junit.jupiter.api.Assertions;

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
    public static LinkedList intSplit(int num) {
        return strSplit(Integer.toString(num));
    }

    public static LinkedList strSplit(String num) {
        LinkedList list = new LinkedList();
        char[] str_num = (num).toCharArray();
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

    public String listToString(){
        StringBuilder result = new StringBuilder();
        Node current = this.head;
        while (current != null){
            result.insert(0,current.getValue());
            current = current.getNext();
        }
        return result.toString();
    }

    public String add(String num1, String num2) {
        LinkedList l1 = strSplit(num1);
        LinkedList l2 = strSplit(num2);

        LinkedList result = new LinkedList();
        Node cur1 = l1.head;
        Node cur2 = l2.head;
        helper_add(result, cur1, cur2, new Node(0));

        return result.listToString();
    }

    public void helper_add(LinkedList result, Node n1, Node n2, Node carry) {
        if (n1 == null & n2 != null) {
            LinkedList ans = intSplit((n2.getValue() + carry.getValue()));
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
            LinkedList ans = intSplit((n1.getValue() + carry.getValue()));
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
            LinkedList ans = intSplit((n1.getValue() + n2.getValue()) + carry.getValue());
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

    public String multiply(String num1, String num2) {
        if (strSplit(num2).listToInt() > strSplit(num2).listToInt()) {
            //switch parameter values
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        //String inputs to linked lists
        LinkedList l1 = strSplit(num1);
        LinkedList l2 = strSplit(num2);

        Node cur1 = l1.head;
        Node cur2 = l2.head;
        Node carry = new Node(0);

        //Result lists not joined until return statement
        LinkedList result = new LinkedList();
        LinkedList current = new LinkedList();

        result.append(0);
        int num_zero = 0;

        while (cur2 != null) {
            if (cur1 != null) {
                LinkedList prod = intSplit((cur1.getValue() * cur2.getValue() + carry.getValue()));
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
                    carry = new Node(0);
                }
                cur2 = cur2.getNext();
                cur1 = l1.head;
                result = strSplit(add(result.listToString(), current.listToString()));
                current = new LinkedList();
                num_zero += 1;
                int i = num_zero;
                while (i != 0) {
                    current.append(0);
                    i--;
                }
            }
        }
        return result.listToString();
    }

    public String exponent(String x, String n) {
        //edge cases n = 0 or n = 1
        if (n.equals("1")){
            return x;
        } else if (n.equals("0")){
            return "1";
        }
        LinkedList result = new LinkedList();
        String res = "1";
        String x2 = multiply(x, x);
        System.out.println(x2);
        if (Integer.parseInt(n) % 2 == 0) {
            int i = Integer.parseInt(n) / 2;
            while (i != 0) {
                res = result.multiply(x2, res);
                i--;
                System.out.println(res);

            }
        }
        else {
            int i = (Integer.parseInt(n)-1) / 2;
            while (i != 0) {
                res = result.multiply(x2, res);
                i--;
                System.out.println(res);

            }
            System.out.println("Final res: " + res);
            res = multiply(res, x);
            System.out.println("Final res * x: " + res);
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

    //attempted driver
    public void driver(String x, String n, String expected){
        String ex_result = exponent(x, n);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + ex_result);
    }
}