class Solution {
    
    public int[] plusOne(int[] digits) {
        
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) digits[i] = 0;
            else {
                digits[i]++;
                return digits;
            }
        }
        
        digits = new int[digits.length + 1];
        digits[0] = 1;
        
        return digits;
        
    }
    
    public int[] plusOne_mysolution(int[] digits) {
        
        int carry = 0;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i];
            if (i == digits.length - 1) {
                value += 1;
                digits[i] = value % 10;
                carry = value / 10;
            } else {
                value += carry;
                digits[i] = value % 10;
            }
            carry = value / 10;
        }
        
        int[] result = new int[digits.length + 1];
        
        if (carry != 0) {
            result[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        } else return digits;
        
    }
}