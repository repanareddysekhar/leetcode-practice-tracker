class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else {
                    int down = Integer.MAX_VALUE;
                    int right = Integer.MAX_VALUE;

                    if(i > 0)
                        down = grid[i][j] + dp[i-1][j];
                    if(j > 0)
                        right = grid[i][j] + dp[i][j-1];
                    
                    dp[i][j] = Math.min(down, right);
                }
            }
        }

        return dp[m-1][n-1];
    }
}