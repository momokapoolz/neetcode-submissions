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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);
        
        int diameter = leftLength + rightLength;

        int sub = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(diameter, sub);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);

        return Math.max(leftLength, rightLength) + 1;
    }
}

// Ý tưởng:
// Diameter của 1 node = depth bên trái + depth bên phải
// Vì path dài nhất đi qua node đó sẽ là:
// leaf trái -> ... -> node hiện tại -> ... -> leaf phải
// Nên:
// - maxDepth(root.left)  = độ sâu lớn nhất bên trái
// - maxDepth(root.right) = độ sâu lớn nhất bên phải

// => cộng lại sẽ ra số cạnh dài nhất đi xuyên qua node hiện tại

// Tuy nhiên diameter lớn nhất của cả cây:
// - có thể đi qua root hiện tại
// - hoặc nằm hoàn toàn trong subtree bên trái
// - hoặc nằm hoàn toàn trong subtree bên phải

// Vì vậy:
// 1. tính diameter đi qua root hiện tại
// 2. recursive tìm diameter lớn nhất của left/right subtree
// 3. lấy max

// Time Complexity hiện tại: O(n^2)
// vì mỗi node lại gọi maxDepth() nhiều lần (brute force btw)
