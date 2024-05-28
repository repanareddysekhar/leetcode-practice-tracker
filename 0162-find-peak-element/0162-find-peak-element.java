class Solution {
    public int findPeakElement(int[] nums) {
        if(null == nums || nums.length < 1) return -1;

        int low = 0;
        int high = nums.length - 1;
        
        while(low < high) {
            int mid = low + (high - low)/2;

            if(nums[mid] <= nums[mid+1])
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}