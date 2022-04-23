class Solution {
    public int racecar(int target) {
        Deque<int[]> queue = new LinkedList<>();
        
        HashSet<String> visited = new HashSet<>();
        
        int[] start = new int[] {0, 1};
        queue.offerLast(start);
        
        visited.add(getKey(start));
        
        int level = 0;
        while (!queue.isEmpty()) {
            for (int k = queue.size(); k > 0; k--) {
                int[] curr = queue.pollFirst();
                
                if (curr[0] == target)
                    return level;
                
                int[] next = drive(curr, 1);
                String key = getKey(next);
                
                if (!visited.contains(key) && 0 < next[0] && next[0] < target * 2) {
                    queue.offerLast(next);
                    visited.add(key);
                }
                
                next = drive(curr, 0);
                key = getKey(next);
                
                if (!visited.contains(key) && 0 < next[0] && next[0] < target * 2) {
                    queue.offerLast(next);
                    visited.add(key);
                }
            }
            level++;
        }
        
        return -1;
    }
    
    String getKey(int[] arr) {
        return arr[0] + " " + arr[1];
    }
    
    int[] drive(int[] arr, int instruction) {
        if (instruction == 1) 
            return new int[] {arr[0] + arr[1], arr[1] * 2};
        else
            return new int[] {arr[0], (arr[1] < 0 ? 1 : -1)};
    }
}

/*
6
[0,1] = [1,2][0,-1]
[1,2] = [3,4][1,-1]
[0,-1] = [-1,-2][0,1]

[3,4] = [7,8][3,-1]
[1,-1] = [0,-2][1,1]

[-1,-2] = [-3,-4][-1,1]

[7,8] = [7,-1]
[3,-1] = [2,-2][3,1]

[0,-2] = [-2,-4][0,1]
[1,1] = [2,2][1,-1]
[7,-1] = [6,-2]



*/