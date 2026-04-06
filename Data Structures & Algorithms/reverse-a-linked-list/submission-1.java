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
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next_temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next_temp;
        }
        return prev;
    }
}

// Tạo 2 biến ảo là node, để tượng trưng cho prev và current node
/* phải lưu biến next hiện tại vào next_temp, bởi vì tí nữa sẽ đổi curr.next thành prev, nên nếu ko lưu biến tạm thì sẽ mất
dấu next ban đầu ní */
/* sau đó tiến hành đảo, current.next = prev, lúc này node đầu tiên có next = null => giống hành vi của node cuối (sau khi 
đảo thì sẽ ra ntn) */
// ngay sau phải update lại prev, prev thành curr hiện tại và curr hiện = next
// bây giờ curr (node 2).next = prev (nốt curr cũ), ...


