class Solution {
    
    public boolean reorderedPowerOf2(int n) {
        int[] count = getCount(n);
        
        for (int i = 0; i < 31; i++) {
            int powerValue = (int) Math.pow(2, i);
            if (isCountSame(count, getCount(powerValue)))
                return true;
        }
        
        return false;
    }
    
    public boolean isCountSame(int[] c1, int[] c2) {
        for (int i = 0; i < 10; i++) {
            if (c1[i] != c2[i])
                return false;
        }
        return true;
    }
    
    public int[] getCount(int n) {
        //System.out.println(n);
        int[] count = new int[10];
        
        while (n > 0) {
            count[n % 10]++;
            n = n / 10;
        }
        //print(count);
        return count;
    }
    
    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}