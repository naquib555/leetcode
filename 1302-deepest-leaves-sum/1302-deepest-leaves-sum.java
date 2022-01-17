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
    int depth;
    public int deepestLeavesSum(TreeNode root) {
        depth = 0;
        return dfs(root, 0, 0);
    }
    
    int dfs(TreeNode root, int currentHeight, int sum) {
        if(root != null) {
            currentHeight++;
            if(currentHeight > depth) {
                depth = currentHeight > depth ? currentHeight : depth;
                sum = 0;
            }
            
            sum = dfs(root.left, currentHeight, sum);
            sum = dfs(root.right, currentHeight, sum);
            if(root.left == null && root.right == null && currentHeight == depth) {
                sum += root.val;
            }
        }
        return sum;
    }
}