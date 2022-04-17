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
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        curr = ans;
        dfs(root);
        return ans.right;
    }
    
    public void dfs(TreeNode root) {
        if (root == null) return;
        
        dfs(root.left);
        
        root.left = null;
        curr.right = root;
        curr = root;
        
        dfs(root.right);
    }
}