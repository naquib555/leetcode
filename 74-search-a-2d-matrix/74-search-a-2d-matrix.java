class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = (m * n) - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int element = matrix[mid / n][mid % n];
            if (element == target) return true;
            else if (element < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return false;
    }
    
    public boolean searchMatrix_old(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int[] mat : matrix) {
            if (target >= mat[0] && target <= mat[n - 1]) {
                if (search(mat, target) != -1) return true;
                else return false;
            }
        }
        return false;
    }
    
    int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return -1;
    }
}