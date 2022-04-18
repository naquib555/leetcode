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
    long result;
    int min;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        result = Long.MAX_VALUE;
        
        dfs(root);
        
        return result == Long.MAX_VALUE ? -1 : (int) result;
    }
    
    void dfs(TreeNode root) {
        if (root == null) return;
        
        if (root.val > min && root.val < result) {
            result = root.val;
        } else if (root.val == min) {
            dfs(root.left);
            dfs(root.right);
        }
    }
}