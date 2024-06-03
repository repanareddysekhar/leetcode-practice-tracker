class Solution {
    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        if(null == grid || grid.length < 1 || grid[0].length < 1)
            return noOfIslands;
        
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    DFSUtil(grid, i, j);
                    noOfIslands++;
                }
            }

        return noOfIslands;
    }

    private void DFSUtil(char[][] grid, int row, int col) {
        if(!isSafe(grid, row, col))
            return;

        grid[row][col] = '0';
        DFSUtil(grid, row+1, col);
        DFSUtil(grid, row-1, col);
        DFSUtil(grid, row, col+1);
        DFSUtil(grid, row, col-1);
    }

    private boolean isSafe(char[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1';
    }
}