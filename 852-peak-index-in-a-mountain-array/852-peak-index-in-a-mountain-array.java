class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        if (arr.length == 3) return 1;
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            System.out.println(mid);
            
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                return mid;
            
            if (arr[mid] <= arr[mid + 1]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    /*
    [0,10,5,2]
    
    
    
    */
}