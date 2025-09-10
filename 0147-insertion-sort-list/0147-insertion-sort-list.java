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
    public ListNode insertionSortList(ListNode head) {
        // Make new listnode and iterate over the old and find the exact position where to insert the value.
        ListNode dummy = new ListNode(0);

        while(head!=null){
            ListNode temp = dummy;
            // Store the value of the next pointer so that at end we can join it 
            ListNode next = head.next;

            // Find the right positon to insert the value
            while(temp.next!=null && temp.next.val<head.val){
                temp = temp.next;
            }

            // Insert the value to positon by proper linking to each other and previous node
            head.next = temp.next;
            temp.next = head;
            head = next;
        }

        // Return the next of dummy list as a head
        return dummy.next;
    }
}