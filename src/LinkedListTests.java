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

        Assertions.assertEquals(list.length(), 6);
        Assertions.assertNotEquals(list.getHead().getValue(), -1);
        Assertions.assertEquals(list.getHead().getValue(), 1);
        Assertions.assertEquals(list.getHead().getNext().getValue(), 2);
        Assertions.assertEquals(list.getHead().getNext().getNext().getValue(), 3);
        Assertions.assertEquals(list.getHead().getNext().getNext().getNext().getValue(), 4);
    }

    @Test
    public void test_split() {
        LinkedList list = new LinkedList();
        LinkedList l = LinkedList.split(436);
        String output = l.toString();
        Assertions.assertEquals(output, "LinkedList: 4, 3, 6");
    }

    @Test
    public void test_insertFront_01() {
        LinkedList list = new LinkedList();
        list.append(2);
        list.append(3);
        list.insertFront(1);
        String output = list.toString();
        Assertions.assertEquals(output, "321");
    }

    @Test
    public void test_insertFront_02() {
        LinkedList list = new LinkedList();
        list.insertFront(3);
        list.insertFront(2);
        list.insertFront(1);
        String output = list.toString();
        Assertions.assertEquals(output, "321");
        Assertions.assertEquals(list.listToInt(), 321);
    }

    @Test
    public void test_check_and_delete_zeros_01() {
        LinkedList list = new LinkedList();
        list.append(0);
        list.append(0);
        list.append(4);
        list.append(3);
        list.append(2);
        list.append(1);

        list.check_and_delete_zeros();
        String output = list.toString();
        Assertions.assertEquals(output, "1234");
    }

    @Test
    public void test_add_01() {
        LinkedList list = new LinkedList();
        int add_result = list.add(436, 12);
        Assertions.assertEquals(add_result, 448);
    }

    @Test
    public void test_add_02() {
        LinkedList list = new LinkedList();
        int add_result = list.add(1, 999);
        Assertions.assertEquals(add_result, 1000);
    }

//    @Test
//    public void test_add_03() {
//        LinkedList list = new LinkedList();
//        int add_result = list.add(1234567890, 987654321);
//        Assertions.assertEquals(add_result, 2222222211);
//    }
//
//    @Test
//    public void test_multiply_01() {
//        LinkedList list = new LinkedList();
//        int mul_result = list.multiply(111111111, 122333444455555);
//        Assertions.assertEquals(mul_result, 13592604925913506171605);
//    }

    @Test
    public void test_multiply_01() {
        LinkedList list = new LinkedList();
        int mul_result = list.multiply(1, 999);
        Assertions.assertEquals(mul_result, 999);
    }

    @Test
    public void test_multiply_02() {
        LinkedList list = new LinkedList();
        int mul_result = list.multiply(12, 15);
        Assertions.assertEquals(mul_result, 180);
    }

    @Test
    public void test_exponent_01() {
        LinkedList list = new LinkedList();
        int ex_result = list.exponent(10, 5);
        Assertions.assertEquals(ex_result, 100000);
    }

    @Test
    public void test_exponent_02() {
        LinkedList list = new LinkedList();
        int ex_result = list.exponent(2, 20);
        Assertions.assertEquals(ex_result, 1048576);
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
        Assertions.assertEquals(list.length(), 4);
        String output = list.toString();
        Assertions.assertEquals(output, "3021");
    }
}
