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
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return maxDepth;
    }
    
    void dfs(TreeNode root, int level) {
        if(root != null) {
            level+=1;
            dfs(root.left, level);
            dfs(root.right, level);
            maxDepth = maxDepth < level ? level : maxDepth;
        }
    }
}