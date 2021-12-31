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
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, "");
        return sum;
    }
    
    void dfs(TreeNode root, String path) {
        if(root != null) {
            path += root.val;
            dfs(root.left, path);
            dfs(root.right, path);
            if(root.left == null && root.right == null) {
                sum += Integer.parseInt(path, 2);
            }
        }
        
    }
}