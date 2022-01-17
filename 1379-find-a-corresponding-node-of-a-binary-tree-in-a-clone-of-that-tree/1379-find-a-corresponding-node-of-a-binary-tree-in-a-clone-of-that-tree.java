/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    boolean foundTarget;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        foundTarget = false;
        return dfs(original, cloned, target, null);
    }
    
    final TreeNode dfs(final TreeNode original, final TreeNode cloned, final TreeNode target, TreeNode result) {
        if(original != null && !foundTarget) {
            foundTarget = original.equals(target);
            if(foundTarget) return cloned;
            result = dfs(original.left, cloned.left, target, result);
            result = dfs(original.right, cloned.right, target, result);
        }
        return result;
    }
}