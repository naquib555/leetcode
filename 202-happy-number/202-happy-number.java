class Solution {
    
    public int getNextNum(int n) {
        
        int sum = 0;
        
        while (n > 0) {
            int d = n % 10;
            
            n = n / 10;
            
            sum += d * d;
        }
        
        return sum;
    }
    
    public boolean isHappy(int n) {
        
        int slow = n;
        int fast = getNextNum(n);
        
        while (fast != 1 && slow != fast) {
            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));
        }
        
        return fast == 1;
    }
    
    public boolean isHappy_withHashTable(int n) {
        
        Set<Integer> resultSet = new HashSet<>();
        
        while (n != 1) {
            resultSet.add(n);
            
            n = getNextNum(n);
            
            if (resultSet.contains(n)) return false;
            
        }
        
        return false;
        
        
        
        /*
        Set<Integer> resultSet = new HashSet<>();
        
        StringBuilder sb;
        
        while (n != 1) {
            
            resultSet.add(n);
            sb = new StringBuilder();
            sb.append(n);
            
            String [] digits = sb.toString().split("");
            if (digits.length == 1) return false;
            
            n = 0;
            for (String digit : digits) {
                int num = Integer.parseInt(digit);
                n += (num * num);
            }
            
            if (resultSet.contains(n)) return false;
            
        }
        
        return true;
        */
    }
    
    /*
    19
    
    1+9
    
    */
}