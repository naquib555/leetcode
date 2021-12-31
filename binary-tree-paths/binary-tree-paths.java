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
    public List<String> binaryTreePaths(TreeNode root) {
        return dfs(root, "", new ArrayList<>());
    }
    
    List<String> dfs(TreeNode root, String path, List<String> list) {
        if(root != null) {
            path += (path.length() == 0 ? root.val : "->" + root.val);
            dfs(root.left, path, list);
            dfs(root.right, path, list);
            
            if(root.left == null && root.right == null) {
                list.add(path);
            }
        }
        return list;
    }
}