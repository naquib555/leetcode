class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        
        char carry = 0;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        while (i >= 0 || j >= 0) {
            char x = (i >= 0) ? a.charAt(i) : '0';
            char y = (j >= 0) ? b.charAt(j) : '0';
            
            char value = '0';
            
            if (x == '1' && y == '1') {
                value = '0';
                if (carry == '1') value = '1';
                carry = '1';
            } else if (x == '1' || y == '1') {
                if (carry == '1') {
                    value = '0';
                    carry = '1';
                } else {
                    value = '1';
                    carry = '0';
                }
            } else if (carry == '1') {
                value = '1';
                carry = '0';
            } else {
                value = '0';
                carry = '0';
            }
            
            sb.insert(0, value);
            
            i--;
            j--;
        }
        
        if (carry == '1') sb.insert(0, carry);
        
        return sb.toString();
    }
}