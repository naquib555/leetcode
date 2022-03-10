class Solution {
    public int findCenter(int[][] edges) {
        int firstNode = edges[0][0];
        int secondNode = edges[0][1];
        
        return firstNode == edges[1][0] || firstNode == edges[1][1] ? firstNode : secondNode;
    }
}

/*
[1,2]
[5,1]
[1,3]
[1,4]

*/