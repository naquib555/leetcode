class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] rem = new int[60];
        
        int result = 0;
        
        for (int i = 0; i < time.length; i++) {
            if (time[i] % 60 == 0)
                result += rem[0];
            else 
                result += rem[60 - time[i] % 60];
            
            rem[time[i] % 60]++; 
        }
        return result;
    }
}

/*
30 + 20 = 60 / 60

30 + 30 / 60

80/60=20

30 20 30 40 40

30 40

1


*/