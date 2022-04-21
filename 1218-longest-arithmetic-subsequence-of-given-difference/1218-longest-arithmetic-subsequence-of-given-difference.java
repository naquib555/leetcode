class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        HashMap<Integer, Integer> count = new HashMap<>();
        
        int result = 0;
        
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i] - difference, 0) + 1);
            result = Math.max(result, count.get(arr[i]));
        }
        
        return result;
    }
}

/*
1,5,7,8,5,3,4,2,1

1=1
5=(5+2)=7=2
7=(7+2)=9=1
8=(8+2)=10=1
3=(3+2)=5=3
4=(4+2)=6=1
2=(2+2)=4=2
1=(1+2)=3=4

*/