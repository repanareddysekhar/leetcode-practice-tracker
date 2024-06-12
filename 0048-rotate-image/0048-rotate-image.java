class Solution {
    public void rotate(int[][] matrix) {
        // Rotate = Transpose -> change columns to rows and rows to columns + Reverse rows

        int m = matrix.length, n = matrix[0].length;

        // Transpose
        int temp = 0;
        for(int i=0; i<m; i++) {
            for(int j=i; j<n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse rows
        for(int i=0; i<m; i++) {
            for(int j=0; j<n/2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = temp;
            }
        }

    }
}