class Solution {
    public int reverse(int x) {
        
        if (x >= -9 && x <= 9) return x;
        
        int reverseNum = 0;
        
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            if (reverseNum > Integer.MAX_VALUE / 10 
                || (reverseNum == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            
            if (reverseNum < Integer.MIN_VALUE / 10 
                || (reverseNum == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            
            reverseNum  = reverseNum * 10 + pop;
        }
        
        return reverseNum;
        
    }
    
    /*
    123
    123/10=12
    123%10=3
    3
    
    12/10=1
    12%10=2
    3+10+2=32
    
    1/10=0
    1%10=1
    32+100+1=321
    */
}