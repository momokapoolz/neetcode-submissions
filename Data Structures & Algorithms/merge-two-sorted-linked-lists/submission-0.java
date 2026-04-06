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
        ArrayList<Integer> arr = new ArrayList<>();

        ListNode curr1 = list1;
        while (curr1 != null) {
            arr.add(curr1.val);
            curr1 = curr1.next;
        }

        ListNode curr2 = list2;
        while (curr2 != null) {
            arr.add(curr2.val);
            curr2 = curr2.next;
        }

        arr.sort(null);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (int val : arr) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }

        return dummy.next;
    }
}