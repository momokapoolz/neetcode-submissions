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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftlength = maxDepth(root.left);
        int rightlength = maxDepth(root.right);

        if ( Math.abs(leftlength - rightlength) <= 1) {
            boolean isBalancedLeft = isBalanced(root.left);
            boolean isBalancedRight = isBalanced(root.right);

            return isBalancedLeft && isBalancedRight;
        } else {
            return false;
        }
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);

        return Math.max(leftLength, rightLength) + 1;
    }
}
