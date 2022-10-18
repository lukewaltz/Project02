import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTests {

    @Test
    public void test_insert() {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);

        Assertions.assertNotEquals(list.getHead().getValue(), -1);
        Assertions.assertEquals(list.getHead().getValue(), 1);
        Assertions.assertEquals(list.getHead().getNext().getValue(), 2);
        Assertions.assertEquals(list.getHead().getNext().getNext().getValue(), 3);
        Assertions.assertEquals(list.getHead().getNext().getNext().getNext().getValue(), 4);
    }

    @Test
    public void test_check_and_delete_zeros_01() {
        LinkedList list = new LinkedList();
        list.append(0);
        list.append(0);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.check_and_delete_zeros();
        String output = list.toString();
        Assertions.assertEquals(output, "LinkedList: 1, 2, 3, 4");
    }

    @Test
    public void test_check_and_delete_zeros_02() {
        LinkedList list = new LinkedList();
        list.append(0);
        list.append(0);
        list.append(0);
        list.append(1);
        list.append(2);
        list.append(0);
        list.append(3);

        list.check_and_delete_zeros();
        String output = list.toString();
        Assertions.assertEquals(output, "LinkedList: 1, 2, 0, 3");
    }
}
