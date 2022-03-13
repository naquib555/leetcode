class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        
        int[] source = {0, 0};
        
        for (int[] ghost : ghosts) {
            if (taxi(ghost, target) <= taxi(source, target))
                return false;
        }
        return true;
    }
    
    public int taxi(int[] P, int[] Q) {
        return Math.abs(P[0] - Q[0]) + Math.abs(P[1] - Q[1]);
    }
}

/*

    0 1 2 3
0       X
1   1
2
3   1

*/