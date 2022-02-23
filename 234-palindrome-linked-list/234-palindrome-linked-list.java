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
    
    public boolean isPalindrome(ListNode head) {
        
        if (head == null) return false;
        
        ListNode firstHalf = getCenterNode(head);
        ListNode reverse = getReverseList(firstHalf.next);
        
        ListNode pointer1 = head;
        ListNode pointer2 = reverse;
        
        boolean result = true;
        
        while (result && pointer2 != null) {
            if (pointer1.val != pointer2.val) return result = false;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        
        firstHalf.next = getReverseList(reverse);
        
        return result;
        
    }
    

    public ListNode getCenterNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode getReverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
    
    
    
    
    public boolean isPalindrome_old(ListNode head) {
        
        int n = 0;
        
        while (head != null) {
            n = n * 10 + head.val;
            head = head.next;
        }
        
        if (n < 0 || (n % 10 == 0 && n != 0)) return false;
        
        int revertNum = 0;
        
        while (n > revertNum) {
            revertNum = (revertNum * 10) + (n % 10);
            n = n / 10;
        }
        
        return n == revertNum || n == (revertNum / 10);
        
    }
}