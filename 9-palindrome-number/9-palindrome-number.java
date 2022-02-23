class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        
        int revertNum = 0;
        
        /*
        121 % 10 = 1
        x = 121 / 10 = 12
        revertNum = 1
        12 % 10 = 2
        x = 12 / 10 = 1
        revertNum = 12
        */
        while (x > revertNum) {
            revertNum = (revertNum * 10) + x % 10;
            x /= 10;
        }
        
        return x == revertNum || x == (revertNum / 10);
        
        
    }
    
    
    
    public boolean isPalindrome_old(int x) {
        
        if (x < 0) return false;
        
        int divisor = 1;
        long test = 1;
        //2147483647
        //1530494976
        
        while (x >= (10 * divisor)) {
            test = test * 10;
            divisor = divisor * 10;
            System.out.println((int)test);
        }
        
        
        System.out.println(x);
        
        int remaining = x;
        
        while (remaining != 0) {
            int right = remaining % 10;
            int left = remaining / divisor;
            
            System.out.printf("left=%d right=%d\n", left, right);
            
            if (right != left) return false;
            
            remaining = (remaining % divisor) / 10;
            divisor /= 100;
            
        }
        
        return true;
    }
    
    /*
    
    1221 % 10 = 1
    1221 % 1000 = 1
    
    1221 / 10 = 122
    122 % 100 = 22
    
    
    */
}