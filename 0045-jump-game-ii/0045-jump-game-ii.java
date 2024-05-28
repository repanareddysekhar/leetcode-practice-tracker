class Solution {
    public int jump(int[] nums) {
        if(null == nums || nums.length < 1) return 0;

        int jumps = 0, currEnd = 0, currFar = 0;

        for(int i=0; i<nums.length; i++) {
            currFar = Math.max(currFar, i + nums[i]);

            if(i < nums.length - 1 && i == currEnd) {
                jumps++;
                currEnd = currFar;
            }
        }

        return jumps;
    }
}