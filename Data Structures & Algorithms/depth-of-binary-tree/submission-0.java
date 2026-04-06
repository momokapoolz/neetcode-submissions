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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }

        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);

        return Math.max(leftLength, rightLength) + 1;
    }
}

// trả về max depth tức là so sánh bên trái và bên phải bên nào > bên dó là max
// cơ bản sẽ +1 để có thể tăng lên bởi vì nếu ko +1 thì cả 2 bên nó cứ mãi là 0
