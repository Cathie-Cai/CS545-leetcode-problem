// ref: https://leetcode.com/problems/add-two-numbers/

public class lc2_linkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + flag;
            } else if (l1 != null) {
                sum = l1.val + flag;
            } else {
                sum = l2.val + flag;
            }
            flag = 0;
            if (sum < 10) {
                cur.next = new ListNode(sum);
                cur = cur.next;
            } else {
                flag = sum / 10; //1
                sum = sum % 10;     // 8
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
            if (l1 != null) {
                l1 = l1.next; // 9
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (flag != 0) cur.next = new ListNode(flag);
        return dummy.next;
    }
}
