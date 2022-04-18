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
    PriorityQueue<Integer> pq;
    public int kthSmallest(TreeNode root, int k) {
        pq = new PriorityQueue<>((a, b) -> b - a);
        
        //dfs(root, k);
        
        //return pq.peek();
        
        List<Integer> result = dfs(root, new ArrayList<>());
        
        return result.get(k - 1);
    }
    
    List<Integer> dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return list;
        
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
        
        return list;
    }
    
    void dfs_old(TreeNode root, int k) {
        if (root == null) return;
        
        pq.add(root.val);
        if (pq.size() > k) pq.poll();
        
        dfs_old(root.left, k);
        dfs_old(root.right, k);
    }
}