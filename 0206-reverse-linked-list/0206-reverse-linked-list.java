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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head, prev = head;
        ListNode next = temp.next;

        while(next != null){
            temp = next;
            next = temp.next;
            temp.next = prev;
            prev = temp;
        }
        head.next = null;
        return head = temp;
    }
}