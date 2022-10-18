import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LinkedListTests {

    @Test
    public void testLinkedListImplementation() {

        MyLinkedList list = new MyLinkedList();
        list = MyLinkedList.insert(list, 1);
        list = MyLinkedList.insert(list, 2);
        list = MyLinkedList.insert(list, 3);
        list = MyLinkedList.insert(list, 4);
        list = MyLinkedList.insert(list, 5);
        list = MyLinkedList.insert(list, 6);

        MyLinkedList.printList(list);

        assertEquals(list.headNode.data, 1 );
        assertEquals(list.headNode.next.data, 2 );
        assertEquals(list.headNode.next.next.data, 3 );
        assertEquals(list.headNode.next.next.next.data, 4 );

        MyLinkedList.deleteByData(list, 1);
        MyLinkedList.printList(list);

        assertEquals(list.headNode.data, 2 );
        assertEquals(list.headNode.next.data, 3 );
        assertEquals(list.headNode.next.next.data, 4 );
        assertEquals(list.headNode.next.next.next.data, 5 );

    }
}
