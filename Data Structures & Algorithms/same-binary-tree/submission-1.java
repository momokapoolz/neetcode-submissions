/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } 
        
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean left_continue = isSameTree(p.left, q.left);
        boolean right_continue = isSameTree(p.right, q.right);

        if (left_continue == true && right_continue == true) {
            return true;
        } else {
            return false;
        }
    }
}

// So sánh hai cây nhị phân bằng đệ quy, kiểm tra từng node tương ứng.
// 1. Nếu cả p và q đều null → hai cây giống nhau tại vị trí này.
// 2. Nếu chỉ một trong hai là null → cấu trúc hai cây khác nhau → false.
// 3. Nếu giá trị của p và q khác nhau → hai cây khác nhau → false.
// 4. Đệ quy kiểm tra cây con bên trái của p và q.
// 5. Đệ quy kiểm tra cây con bên phải của p và q.
// 6. Hai cây chỉ giống nhau khi cả cây con trái và cây con phải đều giống nhau.

// Đệ quy sẽ đi xuống các node con trước.
// Khi gặp node null, hàm return kết quả và quay ngược lên node cha.
// Node cha chỉ được xác nhận giống nhau khi cả hai cây con của nó đều giống nhau.
