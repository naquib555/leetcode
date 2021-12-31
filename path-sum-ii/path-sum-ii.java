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
    
    List<List<Integer>> pathList;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathList = new ArrayList<>();
        return dfs(root, targetSum, 0, new ArrayList<>(), new ArrayList<>());
        //return pathList;
    }
    
     List<List<Integer>> dfs(TreeNode root, int targetSum, int sum, List<Integer> p, List<List<Integer>> pl) {
        if(root != null) {
            sum += root.val;
            p.add(root.val);
            if(root.left == null && root.right == null) {
                if(sum == targetSum) {
                    pl.add(new ArrayList<Integer>(p));
                }
            }
            dfs(root.left, targetSum, sum, p, pl);
            dfs(root.right, targetSum, sum, p, pl);
            p.remove(p.size()-1);
        }
        return pl;
    }
    
}