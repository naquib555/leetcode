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
    public List<Integer> inorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }
    
    List<Integer> dfs(TreeNode root, List<Integer> inOrderList) {
        if(root != null) {
            inOrderList = dfs(root.left, inOrderList);
            inOrderList.add(root.val);
            inOrderList = dfs(root.right, inOrderList);
        }
        return inOrderList;
    }
}