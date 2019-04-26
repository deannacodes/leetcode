/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int res = removeNode(head, n);
        
        if (res == 0)
            head = head.next;
        
        return head;
        
    }
    
    public int removeNode(ListNode head, int n) {
        
        if (head.next == null) {
            
            return --n;
            
        } else {
            int m = removeNode(head.next, n);
            
            if (m > 0 && m < n) {
                return --m;
            } else if (m == 0) {
                head.next = head.next.next;
            } 
            
            return -1;
            
        }
        
    }
    
   
    
}