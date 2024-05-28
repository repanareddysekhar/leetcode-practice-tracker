class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = end/2;

        while(start <= end) {
            mid = start + (end - start)/2;
            if(target == nums[mid])
                return mid;
            
            if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }
}