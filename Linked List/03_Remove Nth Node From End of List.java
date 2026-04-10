/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
*/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int len = 0, i = 1;

        while(curr != null){
            len++;
            curr = curr.next;
        }

        if(len == n) return head.next;

        for(curr = head; i<len - n; i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }
}

/*
This approach is very intuitive and easy to get.

We just iterate in the first-pass to find the length of the linked list - len.

In the next pass, iterate len - n - 1 nodes from start and delete the next node (which would be nth node from end).
*/
