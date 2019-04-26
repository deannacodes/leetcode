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
        int l1Size = 0;
        while (l1Point != null) {
            l1Size++;
            l1Point = l1Point.next;
        }
        
        ListNode l2Point = l2;
        int l2Size = 0;
        while (l2Point != null) {
            l2Size++;
            l2Point = l2Point.next;
        }
        
        ListNode res = addNodes(l1,l2,l1Size,l2Size);
        
        if (res.val > 9) {
            ListNode newRes = new ListNode(res.val / 10);
            newRes.next = res;
            res.val = res.val % 10;
            res = newRes;
        }
        
        return res;
    }
    
    
    public ListNode addNodes(ListNode l1, ListNode l2, int l1Index, int l2Index) {
        
        int val = 0;
        
        if (l1Index != 0 && l2Index != 0) {
            
            if (l1Index == l2Index) {
                val = l1.val + l2.val;
                l1Index--;
                l2Index--;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1Index > l2Index) {
                val = l1.val;
                l1Index--;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2Index--;
                l2 = l2.next;
            }
            
            ListNode ln = new ListNode(val);
            
            ln.next = addNodes(l1, l2, l1Index, l2Index);
            
            if (ln.next != null && ln.next.val > 9) {
                ln.val += ln.next.val / 10;
                ln.next.val = ln.next.val % 10;   
            }
            
            return ln;
            
        } else {
            
            return null;
            
        }
        
        
        
    }
    
}