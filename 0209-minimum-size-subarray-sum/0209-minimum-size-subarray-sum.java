class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // if(null == nums || nums.length < 1) return 0;

        int l = 0, r = 0;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;

        while(r < nums.length) {
            if(sum < target) {
                if(++r == nums.length) break;
                sum += nums[r];
            } else {
                if(l == r) return 1;
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}