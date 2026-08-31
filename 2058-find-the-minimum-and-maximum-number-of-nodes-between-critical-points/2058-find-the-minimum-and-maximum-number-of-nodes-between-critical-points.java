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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head, curr = head.next, next = curr.next;
        int min = Integer.MAX_VALUE;
        int Lastcritical = 0, firstCri = 0;
        int count = 2;//track curr or size

        while(next != null){
            if((prev.val > curr.val && next.val > curr.val) || (prev.val < curr.val && next.val < curr.val)){ //check critical point

                if(Lastcritical == 0){ //found first critical point
                    Lastcritical = count;
                    firstCri = count;
                }
                else{ //calculate min and max with other critical points
                    min = Math.min(min,count-Lastcritical);
                    Lastcritical = count;
                }
            }
            prev = curr;
            curr = next;
            count++;
            next = curr.next;
        }
        if(firstCri == Lastcritical){ //ya to 1 hi critical point mila ya 0
            return new int[] {-1,-1};
        }
        int[] ans = new int[2];
        ans[0] = min;
        ans[1] = Lastcritical-firstCri;
        return ans;
    }
}