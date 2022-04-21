class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        
        if (finalSum % 2 != 0) return result;
        
        long currSum = 0;
        long i = 2;
        
        while ((currSum + i) <= finalSum) {
            
            result.add(i);
            currSum += i;
            i += 2;
        }
        
        long temp = result.get(result.size() - 1);
        result.remove(temp);
        result.add(temp + (finalSum - currSum));
        
        
        return result;
    }
}