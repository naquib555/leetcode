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
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        return dfs(root);
    }
    
    TreeNode dfs(TreeNode root) {
        if(root.right != null) dfs(root.right);
        sum += root.val;
        root.val = sum;
        if(root.left != null) dfs(root.left);
        return root;
    }
}