class Solution {
    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length < 1) return 0;

        int meh = nums[0];
        int msf = nums[0];

        for(int i=1; i<nums.length; i++) {
            meh = Math.max(meh + nums[i], nums[i]);
            msf = Math.max(msf, meh);
        }

        return msf;
    }
}