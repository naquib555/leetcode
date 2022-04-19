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
    public void recoverTree(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        int[] swapValues = findSwapValues(inorderList);
        swapTree(root, swapValues[0], swapValues[1], 2);
    }
    
    public void swapTree(TreeNode root, int x, int y, int count) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                count--;
                if (count == 0) return;
            }
            
            swapTree(root.left, x, y, count);
            swapTree(root.right, x, y, count);
        }
    }
    
    public int[] findSwapValues(List<Integer> list) {
        int n = list.size();
        
        int x = -1, y = -1;
        
        boolean foundFirst = false;
        
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i + 1) < list.get(i)) {
                y = list.get(i + 1);
                
                if (!foundFirst) {
                    x = list.get(i);
                    foundFirst = true;
                } else {
                    break;
                }
                
               
            }
        }
        
        return new int[] {x, y};
    }
    
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}