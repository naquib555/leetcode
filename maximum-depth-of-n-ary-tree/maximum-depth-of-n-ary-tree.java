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
    int maxDepth = 0;
    public int maxDepth(Node root) {
        dfs(root, 0);
        return maxDepth;
    }
    
    void dfs(Node root, int level) {
        if(root != null) {
            level+=1;
            for(Node child : root.children) {
                dfs(child, level);
            }
            maxDepth = maxDepth < level ? level : maxDepth;
        }
    }
}