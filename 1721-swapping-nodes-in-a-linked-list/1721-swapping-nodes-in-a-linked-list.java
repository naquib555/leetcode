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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode firstNode = null;
        ListNode secondNode = null;
        
        ListNode currentNode = head;
        
        int size = 0;
        
        while (currentNode != null) {
            size++;
            if (size == k) firstNode = currentNode;
            currentNode = currentNode.next;
        }
        
        secondNode = head;
        
        for (int i = 0; i < size - k; i++) {
            secondNode = secondNode.next;
        }
        
        int temp = secondNode.val;
        secondNode.val = firstNode.val;
        firstNode.val = temp;
        
        return head;
    }
    
    /*
    [1,2,3,4,5]
    
    first=2
    second=4
    thrid=1
    
    */
}