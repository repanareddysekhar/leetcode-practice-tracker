/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // return mergeKList_PQ(lists);

        return mergeKLists_util(lists, 0, lists.length-1);
    }

    private ListNode mergeKLists_util(ListNode[] lists, int s, int e) {
        if(s > e) return null;
        if(s == e) return lists[s];
        int m = s + (e-s)/2;

        ListNode l1 = mergeKLists_util(lists, s, m);
        ListNode l2 = mergeKLists_util(lists, m+1, e);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    private ListNode mergeKList_PQ(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node : lists)
            if(null != node)
                pq.add(node);
            
        ListNode dummyNode = new ListNode();
        ListNode tail = dummyNode;

        while(!pq.isEmpty()) {
            ListNode temp = pq.poll();
            tail.next = temp;
            tail = tail.next;
            if(tail.next != null)
                pq.offer(tail.next);
        }

        return dummyNode.next;
    }
}