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
    public List<Integer> postorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }
    
    List<Integer> dfs(TreeNode root, List<Integer> postOrderList) {
        if(root != null) {
            postOrderList = dfs(root.left, postOrderList);
            postOrderList = dfs(root.right, postOrderList);
            postOrderList.add(root.val);
        }
        return postOrderList;
    }
}