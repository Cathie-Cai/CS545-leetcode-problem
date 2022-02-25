//ref: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class lc19_linkedList {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = getLen(head);
        if (l == 1) return head.next;
        int k = l - n;
        if (n == l) {
            return head.next;
        }
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode cur = dum;
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        cur.next =cur.next.next;
        return dum.next;

    }
    public int getLen(ListNode head) {

        int len =0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {
        lc19_linkedList sol = new lc19_linkedList();
        ListNode head = new ListNode(0);
        sol.removeNthFromEnd(head,2);
    }
}
