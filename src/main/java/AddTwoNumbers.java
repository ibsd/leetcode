public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int plus = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + plus;
            if (sum > 9) {
                plus = 1;
                sum -= 10;
            } else {
                plus = 0;
            }
            current.next = new ListNode(sum);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + plus;
            if (sum > 9) {
                plus = 1;
                sum -= 10;
            } else {
                plus = 0;
            }
            current.next = new ListNode(sum);
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + plus;
            if (sum > 9) {
                plus = 1;
                sum -= 10;
            } else {
                plus = 0;
            }
            current.next = new ListNode(sum);
            current = current.next;
            l2 = l2.next;
        }

        if (plus != 0) {
            current.next = new ListNode(plus);
        }
        return result.next;
    }
}
