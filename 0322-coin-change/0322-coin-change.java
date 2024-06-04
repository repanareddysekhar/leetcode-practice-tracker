class Solution {
    public int coinChange(int[] coins, int amount) {
        if(null == coins || amount <= 0) return 0;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int coin : coins) {
            for(int j=coin; j<=amount; j++) {
                if(dp[j-coin] != Integer.MAX_VALUE) {
                    int val = dp[j-coin] + 1;
                    dp[j] = Math.min(dp[j], val);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}