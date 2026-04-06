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
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        ListNode head1 = list1;
        ListNode head2 = list2;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        return dummy.next;
    }
}

// ý tưởng là tạo 1 listnode mới và nối tiếp từ nó
// đặt 2 con trỏ tại 2 node ban đầu, so sánh 2 node đứng đầu, cái nào bé hơn thì nối nó vào listnode mới, xong next
/*
ví dụ:
 - list: 1-3-5
 - list: 2-4-6

1 < 2 => 1 nối vào listnode mới, xong dịch lên next (giờ là 3), lại ss 2 < 3 ...
*/

// sau khi kết thúc while, đoạn if Nối toàn bộ phần còn lại của list chưa hết vào kết quả

/*
dummy không thay đổi, nhưng dummy.next vẫn có giá trị dù chỉ gán qua current

Nguyên nhân cốt lõi

Trong Java, biến kiểu object (như ListNode) chỉ là reference (con trỏ), không phải bản thân object.

ListNode current = dummy;


Dòng này không tạo node mới, mà chỉ làm cho:

current và dummy

cùng trỏ tới một object trong heap

Phân biệt 2 khái niệm quan trọng
1️⃣ Reference (biến)

Có thể thay đổi

Chỉ là địa chỉ trỏ tới object

2️⃣ Object (ListNode trong heap)

Là dữ liệu thật

Có thể bị sửa thông qua bất kỳ reference nào trỏ tới nó
*/