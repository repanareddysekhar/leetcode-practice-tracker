class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(dfs(board, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int ind) {
        if(word.length()==ind) return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || ind >= word.length() || board[r][c] != word.charAt(ind))
            return false;
        
        char temp = board[r][c];
        board[r][c] = '*';

        boolean ans = dfs(board, word, r-1, c, ind+1) || dfs(board, word, r+1, c, ind+1) || dfs(board, word, r, c+1, ind+1) || dfs(board, word, r, c-1, ind+1);

        board[r][c] = temp;

        return ans;
    }
}