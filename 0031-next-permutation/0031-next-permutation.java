class Solution {
    public void nextPermutation(int[] nums) {
        if(null == nums || nums.length < 2) return;

        int breakPoint = nums.length-2;

        // Find nums[i] < nums[i+1]
        while(breakPoint >= 0 && nums[breakPoint] >= nums[breakPoint+1])
            breakPoint--;

        if(breakPoint >= 0) {
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[breakPoint])
                j--;
            swap(nums, breakPoint, j);
        }

        reverse(nums, breakPoint+1);
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    void reverse(int[] nums, int pos) {
        int low = pos, high = nums.length-1;
        while(low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }
}