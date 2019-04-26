/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode l1Point = l1;
        ListNode l2Point = l2;
        ListNode res = new ListNode(0);
        ListNode resPoint = res;
        int carry = 0;
        
        while (l1Point != null || l2Point != null || carry != 0) {            
            
            int val = 0;
            if (l1Point != null)
                val += l1Point.val;
            
            if (l2Point != null)
                val += l2Point.val;
            
            val += carry;
            carry = 0;
            
            if (val > 9) {
                carry = val / 10;
                val = val % 10;                
            }
            
            ListNode ln = new ListNode(val);
            resPoint.next = ln;
            resPoint = ln;
            
            if (l1Point != null)
                l1Point = l1Point.next;
            
            if (l2Point != null)
                l2Point = l2Point.next;
            
        }
        
        res = res.next;
        
        return res;
        
    }
}