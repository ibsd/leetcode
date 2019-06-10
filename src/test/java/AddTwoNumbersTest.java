import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoNumbersTest {

    @Test
    void normal() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = null;

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = null;

        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        assertEquals(7, result.val);
        assertEquals(0, result.next.val);
        assertEquals(8, result.next.next.val);
    }

    @Test
    void only_one() {
        ListNode l1 = new ListNode(5);
        l1.next = null;

        ListNode l2 = new ListNode(5);
        l2.next = null;

        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        assertEquals(0, result.val);
        assertEquals(1, result.next.val);
    }
}