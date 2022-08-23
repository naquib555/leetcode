class Solution {
    public String nearestPalindromic(String n) {
        
        int length = n.length();
        int i = length / 2;
        
        if (length % 2 == 0)
            i--;
        
        long left = Long.parseLong(n.substring(0, i + 1));
        
        List<Long> candidates = new ArrayList<>();
        
        candidates.add(reversePalindrome(left, length % 2 == 0));
        candidates.add(reversePalindrome(left + 1, length % 2 == 0));
        candidates.add(reversePalindrome(left - 1, length % 2 == 0));
        candidates.add((long) Math.pow(10, length - 1) - 1);
        candidates.add((long) Math.pow(10, length) + 1);
        
        long diff = Long.MAX_VALUE;
        long result = 0;
        long nLong = Long.parseLong(n);
        
        for (long candidate : candidates) {
            if (candidate == nLong) continue;
            
            if (Math.abs(candidate - nLong) < diff) {
                diff = Math.abs(candidate - nLong);
                result = candidate;
            } else if (Math.abs(candidate - nLong) == diff) {
                result = Math.min(candidate, result);
            }
        }
        
        return String.valueOf(result);
        
        
        
    }
    
    public long reversePalindrome(long num, boolean isEven) {
        long res = num;
        
        if (!isEven) {
            res /= 10;
        }
        
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        
        return res;
    }
}