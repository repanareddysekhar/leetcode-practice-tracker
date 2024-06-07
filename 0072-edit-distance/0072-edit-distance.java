class Solution {
    
    private Integer[][] mem;

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        mem = new Integer[m][n];

        return minDistance(word1, word2, m-1, n-1);
    }

    private int minDistance(String w1, String w2, int m, int n) {
        if(m < 0) return n+1;
        if(n < 0) return m+1;

        if(mem[m][n] != null) return mem[m][n];

        if(w1.charAt(m) == w2.charAt(n))
            return minDistance(w1, w2, m-1, n-1);

        // insert, remove, replace 
        return mem[m][n] = 1 + Math.min(minDistance(w1, w2, m, n-1), Math.min(minDistance(w1, w2, m-1, n), minDistance(w1, w2, m-1, n-1)));
    }
}