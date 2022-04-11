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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        StringBuilder s = new StringBuilder();
        StringBuilder d = new StringBuilder();
        
        find(root, startValue, s);
        find(root, destValue, d);
        
        int i = 0;
        int n = Math.min(s.length(), d.length());
        
        while (i < n && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
            i++;
        
        return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
    }
    
    boolean find(TreeNode root, int target, StringBuilder sb) {
        
        if (root.val == target) return true;
        
        if (root.left != null && find(root.left, target, sb)) {
            sb.append("L");
        } else if (root.right != null && find(root.right, target, sb)) {
            sb.append("R");
        }
        return sb.length() > 0;
    }
}