/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(Node root) {
        result = new ArrayList<>();
        
        if (root == null) return result;
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while (!q.isEmpty()) {
            
            int n = q.size();
            
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                level.add(node.val);
                q.addAll(node.children);
            }
            result.add(level);
                
        }
        
        return result;
    }
    
    void dfs(Node root) {
        if (root == null)
            return;
        
        List<Integer> level = new ArrayList<>();
        
        for (Node child : root.children) {
            level.add(child.val);
            dfs(child);
        }
        result.add(level);
    }
}