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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        
        postOrder(root, new HashMap<>(), result);
        
        return result;
    }
    
    String postOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) return "#";
        
        StringBuilder serialize = new StringBuilder();
        serialize.append(root.val + "|");
        serialize.append(postOrder(root.left, map, result) + "|");
        serialize.append(postOrder(root.right, map, result));
        
        map.put(serialize.toString(), map.getOrDefault(serialize.toString(), 0) + 1);
        
        if (map.get(serialize.toString()) == 2) result.add(root);
        return serialize.toString();
    }
}

/*
[1,2,3,4,null,2,4,null,null,4]

Post order:
4 2 1 4 2 4 3
*/