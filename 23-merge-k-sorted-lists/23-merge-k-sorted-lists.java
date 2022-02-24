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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        
        for (ListNode ln : lists)
            if (ln != null) pq.add(ln);
        
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        
        while (!pq.isEmpty()) {
            ListNode fetchedNode = pq.poll();
            
            cursor.next = fetchedNode;
            cursor = cursor.next;
            
            fetchedNode = fetchedNode.next;
            
            if (fetchedNode != null) pq.add(fetchedNode);
        }
        
        return head.next;
        
    }
    
    /*
    Input = [[1,4,5],[1,3,4],[2,6]]
    
    Heap = [2,6][1,4,5][1,3,4]
    
    
    Heap = [3,4][2,6][1,4,5]
    Result = 1
    
    Heap = [4,5][3,4][2,6]
    Result = 1,1
    
    Heap = [6][4,5][3,4]
    Result = 1,1,2
    
    */
}