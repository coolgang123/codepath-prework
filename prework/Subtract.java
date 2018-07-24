/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode subtract(ListNode input) {
        ListNode root = input;
        if (input == null || input.next == null) {
            return input;
        }

        ListNode current = root;
        ListNode next = root.next;
        
        while (next != null && next.next != null){
            current = current.next;
            next = next.next.next;
        }
        
        ListNode reversed = reverse(current.next);
        
        ListNode forward = input;
        ListNode backward = reversed;
        while(backward != null){
            forward.val = backward.val - forward.val;
            forward = forward.next;
            backward = backward.next;
        }
        
        current.next = reverse(reversed);
        return root;
    }
    
    ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}

