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
    public boolean hasCycle(ListNode head) {
        ListNode tmp = head;

        HashSet<ListNode> seenNode = new HashSet<>();

        while (tmp != null) {
            if (seenNode.contains(tmp)) {
                return true;
            } else {
                seenNode.add(tmp);
                tmp = tmp.next;
            }
        }
        return false;
    }
}

// taọ 1 hashset lưu các node ko lặp
// while tmp(head) khác null để bắt đầu duyệt linkedlist
// nếu hashset lặp node thì return true luôn, ko thì add node vào hashset và .next để chuyển sang node tiếp
// hết while loop thì return false thôi
// khá dễ btw

