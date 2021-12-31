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
    Set visitedNodes = null;
    public boolean isUnivalTree(TreeNode root) {
        visitedNodes = new HashSet();
        dfs(root);
        if(visitedNodes.size() == 1) return true;
        else return false;
    }
    
    void dfs(TreeNode root) {
        if(root != null) {
            visitedNodes.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
        
    }
}