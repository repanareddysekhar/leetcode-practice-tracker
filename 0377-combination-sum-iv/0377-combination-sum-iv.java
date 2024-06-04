class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int sum=1; sum<=target; sum++) {
            for(int i=0; i<nums.length; i++) {
                if(nums[i]<=sum) {
                    dp[sum] = dp[sum] + dp[sum-nums[i]];
                }
            }
        }

        return dp[target];
    }
}