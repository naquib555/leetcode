class Solution {
    public List<List<Integer>> generate(int numRows) {
        //1
        //1 
        
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            
            row.add(0, 1);
            
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            result.add(i, new ArrayList<>(row));
        }
        
        return result;
    }
}