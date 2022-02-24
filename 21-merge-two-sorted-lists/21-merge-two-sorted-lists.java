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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cursor.next = list2;
                list2 = list2.next;
            } else {
                cursor.next = list1;
                list1 = list1.next;
            }
            cursor = cursor.next;
        }
        
        cursor.next = (list1 == null) ? list2 : list1;
        
        return head.next;
    }
    
    /*
    list1 = [1,2,4], list2 = [1,3,4]
    
    1,
    1>1
    
    
    */
}