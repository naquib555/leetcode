class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> mapping = new HashMap<>();
        
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
        
        int result = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i < s.length() - 1 && mapping.get(s.charAt(i + 1)) > mapping.get(s.charAt(i))) {
                result -= mapping.get(s.charAt(i));
            } else {
                result += mapping.get(s.charAt(i));
            }
        }
        
        return result;
    }
}