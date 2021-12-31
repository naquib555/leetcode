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
    int min;
    public int minDiffInBST(TreeNode root) {
        return dfs(root, new ArrayList<>(), Integer.MAX_VALUE);
    }
    
    int dfs(TreeNode root, List<Integer> order, int min) {
        if(root != null) {
            min = dfs(root.left, order, min);
            min = order.size() > 0 ? Math.min(min, root.val - order.get(order.size()-1)) : min;
            order.add(root.val);
            min = dfs(root.right, order, min);
        }
        return min;
    }
}