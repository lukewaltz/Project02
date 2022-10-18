import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTests {

    @Test
    public void test_insert() {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);

        Assertions.assertNotEquals(list.getFirst().getValue(), -1);
        Assertions.assertEquals(list.getFirst().getValue(), 1);
        Assertions.assertEquals(list.getFirst().getNext().getValue(), 2);
        Assertions.assertEquals(list.getFirst().getNext().getNext().getValue(), 3);
        Assertions.assertEquals(list.getFirst().getNext().getNext().getNext().getValue(), 4);
    }

    @Test
    public void test_check_and_delete_zeros_01() {
        LinkedList list = new LinkedList();
        list.insert(0);
        list.insert(0);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        list.check_and_delete_zeros();
        String output = list.toString();
        Assertions.assertEquals(output, "LinkedList: 1, 2, 3, 4");
    }

    @Test
    public void test_check_and_delete_zeros_02() {
        LinkedList list = new LinkedList();
        list.insert(0);
        list.insert(0);
        list.insert(0);
        list.insert(1);
        list.insert(2);
        list.insert(0);
        list.insert(3);

        list.check_and_delete_zeros();
        String output = list.toString();
        Assertions.assertEquals(output, "LinkedList: 1, 2, 0, 3");
    }
}
