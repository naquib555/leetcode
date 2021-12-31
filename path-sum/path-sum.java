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
    boolean isSumEqual;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        isSumEqual = false;
        dfs(root, targetSum, 0);
        return isSumEqual;
    }
    
    void dfs(TreeNode root, int targetSum, int sum) {
        if(!isSumEqual && root != null) {
            sum += root.val;
            if(root.left == null && root.right == null) {
                if(sum == targetSum) isSumEqual = true;
            }
            dfs(root.left, targetSum, sum);
            dfs(root.right, targetSum, sum);
            
        }
    }
}