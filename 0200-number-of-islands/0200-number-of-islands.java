class Solution {
    public int numIslands(char[][] grid) {
        if(null == grid || grid.length < 1 || grid[0].length < 1) return 0;

        int cnt = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    DFSUtil(grid, i, j);
                    cnt++;
                } 
            }
        }

        return cnt;
    }

    private void DFSUtil(char[][] grid, int r, int c) {
        if(r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] == '0')
            return;
        
        grid[r][c] = '0';
        DFSUtil(grid, r-1, c);
        DFSUtil(grid, r+1, c);
        DFSUtil(grid, r, c-1);
        DFSUtil(grid, r, c+1);
    }
}