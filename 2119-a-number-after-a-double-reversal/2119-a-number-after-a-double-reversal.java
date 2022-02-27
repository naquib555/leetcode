class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num >= 0 && num <= 9) return true;
        
        return num == getReverseNum(getReverseNum(num));
    }
    
    int getReverseNum(int num) {
        int reverseNum = 0;
        
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
            
            reverseNum = reverseNum * 10 + pop;
        }
        
        return reverseNum;
    }
}