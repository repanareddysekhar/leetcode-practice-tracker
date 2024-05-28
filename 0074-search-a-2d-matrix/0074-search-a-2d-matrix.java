class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length < 1) return false;
        
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(matrix[mid/n][mid%n] == target)
                return true;

            if(matrix[mid/n][mid%n] < target) 
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
}