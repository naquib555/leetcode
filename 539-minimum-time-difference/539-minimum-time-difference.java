class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        boolean [] minutesArray = new boolean [24 * 60];
        
        for (String tp : timePoints) {
            String[] timePoint = tp.split(":");
            
            int minutes = Integer.parseInt(timePoint[0]) * 60 + Integer.parseInt(timePoint[1]);
            
            if (minutesArray[minutes]) return 0;
            
            minutesArray[minutes] = true;
        }
        
        int minVal = Integer.MAX_VALUE;
        int first = -1;
        int current = -1;
        int prev = -1;
        
        for (int i = 0; i < minutesArray.length; i++) {
            if (minutesArray[i]) {
                if (first == -1) {
                    first = i;
                    prev = i;
                } else {
                    current = i;
                    minVal = Math.min(minVal, current - prev);
                    prev = current;
                }
            }
        }
        
        return Math.min(minVal, (minutesArray.length - current + first));
    }
}

/*
22:50
21:00
-----
1:50

21+23=
50+60=90/60=3


*/