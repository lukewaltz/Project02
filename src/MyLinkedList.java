//key should be what digit of the expression it is
//value should be the value of the digit

public class MyLinkedList {

    Node headNode;
    Node tailNode;
    //node is a linkedList instance variable
    //encapsulating node in linked list
    public static class Node{
        //node instance variables
        int data;
        Node next;
        Node prev;

        //node constructor
        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }
    //inserting new node to end of list
    public static MyLinkedList insert(MyLinkedList list, int data){
        //initialize LL with given parameters
        Node newNode = new Node(data);
        newNode.next = null;

        //if list empty make new node head
        if(list.headNode == null){
            list.headNode = newNode;
        } else{
            Node prevNode = list.headNode;
            while(prevNode.next != null){
                prevNode = prevNode.next;
            }
            prevNode.next = newNode;
            list.tailNode = newNode;
            list.tailNode.prev = prevNode;

        }
        return list;

    }

    //deletion
    //by key
    public static MyLinkedList deleteByData(MyLinkedList list, int data){
        //remember headNode
        Node cur = list.headNode, prev = null;

        //delete head (if head holds key)
        if (cur != null && cur.data == data){
            list.headNode = cur.next;
            return list;
        }

        //have to find key
        while (cur != null && cur.data != data){
            prev = cur;
            cur = cur.next;
        }
        // moves past this loop once key is found or its not in the list
        //key not found
        if (cur == null){
            return list;
        }
        //else key = cur
        prev.next = cur.next;
        return list;
    }

    public int popTail(MyLinkedList list){
        Node cur = list.headNode;
        while(cur.next != list.tailNode){
            cur = cur.next;
        }
        int returnVal = list.tailNode.data;
        cur.next = null;
        list.tailNode = cur;

        return returnVal;
    }

    public static void printList(MyLinkedList list){
        Node cur = list.headNode;
        System.out.print("\nLinked List: ");

        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println("\n");
    }

    public int getHashCode(MyLinkedList list){
        Node cur = list.headNode;
        int hCode = 31;
        while(cur.next != null){
            hCode += cur.hashCode();
            cur = cur.next;
        }
        return hCode >>> 31;
    }

}
