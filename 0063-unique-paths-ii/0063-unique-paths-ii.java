class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0] == 1) return 0;

        int R = grid.length;
        int C = grid[0].length;

        grid[0][0] = 1;

        for(int i=1; i<R; i++) {
            if(grid[i][0] == 1)
                grid[i][0] = 0;
            else if(grid[i-1][0] == 1)
                grid[i][0] = 1;
        }

        for(int j=1; j<C; j++) {
            if(grid[0][j] == 1)
                grid[0][j] = 0;
            else if(grid[0][j-1] == 1)
                grid[0][j] = 1;
        }

        for(int i=1; i<R; i++) {
            for(int j=1; j<C; j++) {
                if(grid[i][j] == 1)
                    grid[i][j] = 0;
                else
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }



        return grid[R-1][C-1];
    }
}