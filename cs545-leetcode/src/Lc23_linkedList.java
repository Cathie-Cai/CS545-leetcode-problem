// difficulty level: hard
// ref: https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc23_linkedList {
    public static class ListNode {
        int val;
        lc19_linkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, lc19_linkedList.ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val == n2.val) return 0;
                return n1.val < n2.val ? -1 : 1;
            }
        });

        for (ListNode node: lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode n = minHeap.poll();
            ListNode next = n.next;
            cur.next = n;
            if (next != null) {
                minHeap.offer(next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
