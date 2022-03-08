class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        int i = 0, n = words.length;
        
        while (i < n) {
            int j = i + 1;
            
            int lineLength = words[i].length();
            
            while (j < n && (lineLength + words[j].length() + (j - i - 1)) < maxWidth) {
                lineLength += words[j].length();
                j++;
            }
            
            int remaining = maxWidth - lineLength;
            int noOfWords = j - i;
            
            if (noOfWords == 1 || j >= n) result.add(leftJustify(i, j, remaining, words));
            else result.add(middleJustify(i, j, remaining, words));
            
            i = j;
        }
        
        
        return result;
    }
    
    String leftJustify(int i, int j, int remaining, String[] words) {
        int spacesRight = remaining - (j - i - 1);
        
        StringBuilder sb = new StringBuilder(words[i]);
        
        for (int k = i + 1; k < j; k++) {
            sb.append(" " + words[k]);
        }
        
        sb.append(" ".repeat(spacesRight));
        
        return sb.toString();
    }
    
    String middleJustify(int i, int j, int remaining, String[] words) {
        int spaceNeeded = j - i - 1;
        int spaces = remaining / spaceNeeded;
        int extraSpaces = remaining % spaceNeeded;
        
        StringBuilder sb = new StringBuilder(words[i]);
        
        
        for (int k = i + 1; k < j; k++) {
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            sb.append(" ".repeat(spacesToApply));
            sb.append(words[k]);
        }
        
        return sb.toString();
    }
}
/*
"This    is    an",
"example  of text",
"justification.  "
*/