class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // Similar to Rotting oranges
        if(null == mat || mat.length < 1 || mat[0].length < 1)
            return new int[0][0];

        Queue<int[]> q = new LinkedList<>();
        int R = mat.length;
        int C = mat[0].length;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(mat[i][j] == 0)
                    q.add(new int[]{i, j});
                else
                    mat[i][j] = -1;
            }
        }

        int length = 0;
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int size = q.size();
            length++;

            for(int i=0; i<size; i++) {
                int pos[] = q.poll();
                for(int j=0; j<4; j++) {
                    int row = pos[0] + dir[j][0];
                    int col = pos[1] + dir[j][1];

                    if(row < 0 || col < 0 || row >= R || col >= C || mat[row][col] >= 0) continue;
                    
                    mat[row][col] = length;
                    q.add(new int[]{row, col});
                }
            }
        }

        return mat;
    }
}