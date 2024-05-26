class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if(start > end) return -1;

        int mid = start + (end - start)/2;

        if(nums[mid] == target) return mid;

        if(nums[start] <= nums[mid]) {
            if(target <= nums[mid] && target >= nums[start])
                return search(nums, target, start, mid-1);
            return search(nums, target, mid+1, end);
        }

        if(target <= nums[end] && target >= nums[mid])
            return search(nums, target, mid+1, end);
        
        return search(nums, target, start, mid-1);
    }
}