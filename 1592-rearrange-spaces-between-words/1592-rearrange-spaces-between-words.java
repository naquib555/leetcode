class Solution {
    public String reorderSpaces(String text) {
        
        int totalSpaces = 0;
        
        List<String> words = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                totalSpaces++;
                if (sb.toString().length() != 0) {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(text.charAt(i));
            }
        }
        
        if (sb.toString().length() != 0) {
            words.add(sb.toString());
        }
        sb = new StringBuilder(words.get(0));
        if (words.size() == 1) {
            return sb.append(" ".repeat(totalSpaces)).toString();
        }
        
        int spaces = totalSpaces / (words.size() - 1);
        int extraSpaces = totalSpaces % (words.size() - 1);
        
        
        for (int i = 1; i < words.size(); i++) {
            sb.append(" ".repeat(spaces));
            sb.append(words.get(i));
        }
        
        sb.append(" ".repeat(extraSpaces));
        
        return sb.toString();
    }
}