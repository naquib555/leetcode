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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (root == null) return results;
        
        dfs(root, 0, results);
        
        return results;
    }
    
    void dfs(TreeNode root, int level, List<List<Integer>> results) {
        if (level >= results.size()) {
            
            LinkedList<Integer> newLevel = new LinkedList<>();
            newLevel.add(root.val);
            results.add(newLevel);
            
        } else {
            if (level % 2 == 0)
                results.get(level).add(root.val);
            else
                results.get(level).add(0, root.val);
        }
        
        if (root.left != null)
            dfs(root.left, level + 1, results);
        if (root.right != null)
            dfs(root.right, level + 1, results);
    }
}