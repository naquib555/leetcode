class Solution {
    public String getHint(String secret, String guess) {
        
        Map<Character, Integer> mySecretCount = new HashMap<>();
        
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                mySecretCount.put(secret.charAt(i), mySecretCount.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }
        
        
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) 
                && mySecretCount.getOrDefault(guess.charAt(i), 0) != 0) {
                cows++;
                int count = mySecretCount.getOrDefault(guess.charAt(i), 0);
                if (count != 0) {
                    count--;
                    if (count == 0) mySecretCount.remove(guess.charAt(i));
                    else mySecretCount.put(guess.charAt(i), count);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(bulls);
        result.append("A");
        result.append(cows);
        result.append("B");
        
        return result.toString();
        
    }
}

/*
1807
7810

11421
01115

check bulls
count of bulls = 1
Map: 
1, c=1
2, c=1
3, c=1

count of cows = 1



*/