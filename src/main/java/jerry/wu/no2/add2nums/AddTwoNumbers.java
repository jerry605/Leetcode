package jerry.wu.no2.add2nums;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode root = new ListNode(0);
        ListNode curr = root, p1 = l1, p2 = l2;
        int inc = 0;
        while (p1 != null || p2 != null || inc != 0) {
            int first = 0, second = 0;
            if (p1 != null) {
                first = p1.val;
            }
            if (p2 != null) {
                second = p2.val;
            }
            int sum = (first + second + inc) % 10;
            inc = (first + second + inc) /  10;
            ListNode nd = new ListNode(sum);
            curr.next = nd;
            curr = nd;
            if (p1 != null )
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
        }
        return root.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}