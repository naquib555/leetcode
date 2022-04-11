class Solution {
    public int minInsertions(String s) {
        int right = 0;
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (right % 2 != 0) {
                    right--;
                    result++;
                }
                right += 2;
            } else {
                right--;
                if (right < 0) {
                    right += 2;
                    result++;
                }
            }
        }
        return result + right;
    }
}