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
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        result = new ArrayList<>();
        
        if (root == null) return result;
        
        dfs(root, 0);
        
        return result;
        
        
    }
    // LNR NLR LRN
    
   void dfs(TreeNode root, int level) {
       if (result.size() == level)
           result.add(new ArrayList<>());
       
       result.get(level).add(root.val);
       
       if (root.left != null)
           dfs(root.left, level + 1);
       if (root.right != null)
           dfs(root.right, level + 1);
   }
}