/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        int peakIndex = getPeakIndex(size, mountainArr);
        
        int peakValue = mountainArr.get(peakIndex);
        
        int left = 0;
        int right = size - 1;
        
        int targetIndex = -1;
        
        if (target == peakValue) return peakIndex;
        
        targetIndex = search(0, peakIndex - 1, target, mountainArr, false);
        
        if (targetIndex == -1)
            targetIndex = search(peakIndex + 1, size - 1, target, mountainArr, true);
        
        /*if (target >= mountainArr.get(0) && target < peakValue) {
            System.out.println(peakValue);
            targetIndex = search(0, peakIndex - 1, target, mountainArr);
        }
        else {
            targetIndex = search(peakIndex + 1, size - 1, target, mountainArr);
        }*/
        
        return targetIndex;
    }
    
    int search(int left, int right, int target, MountainArray mountainArr, boolean isReverse) {
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //System.out.printf("left=%d, mid=%d, right=%d\n", left, mid, right);
            int midValue = mountainArr.get(mid);
            
            if (midValue == target) return mid;
            
            if (isReverse) {
                if (midValue < target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (midValue > target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
    
    
    int getPeakIndex(int size, MountainArray mountainArr) {
        int left = 0;
        int right = size - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            int midValue = mountainArr.get(mid);
            int nextMidValue = mountainArr.get(mid + 1);
            
            if (midValue < nextMidValue)
                left = mid + 1;
            else right = mid - 1;
            
        }
        return left;
    }
    
    
    int getPeakIndex_old(int size, MountainArray mountainArr) {
        int left = 0;
        int right = size - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.printf("left=%d, mid=%d, right=%d\n", left, mid, right);
            int midValue = mountainArr.get(mid);
            int nextMidValue = mountainArr.get(mid + 1);
            int prevMidValue = mountainArr.get(mid - 1);
            
            if (midValue > nextMidValue
                && midValue > prevMidValue)
                return mid;
            
            if (midValue < nextMidValue)
                left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    /*
    
    [1,2,3,4,5,3,1] 3
    
    test cases
    [0,5,3,1]
    1
    [0,5,1]
    1
    [1,2,3,4,5,3,1]
    3
    [0,1,2,4,2,1]
    3
    
    */
}