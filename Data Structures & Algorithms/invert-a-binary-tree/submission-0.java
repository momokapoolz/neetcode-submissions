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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

// ý tưởng cơ bản là duyệt qua từng node và swap node trái và phải
// check null ko thì crash
/* sử dụng đệ quy để duyệt qua từng node, ban đầu tham số là root, sau đó gọi lại chính nó với tham số lần
lượt là root.left và right */ 

// bài này thực ra khá dễ, đọc code tí là tự hiểu (FR)
