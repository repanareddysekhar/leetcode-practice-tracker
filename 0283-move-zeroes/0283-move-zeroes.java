class Solution {
    public void moveZeroes(int[] nums) {
        if(null == nums || nums.length < 2) return;

        int i=0, j=0;
        while(j < nums.length) {
            if(nums[j] == 0) j++;
            else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
    }
}