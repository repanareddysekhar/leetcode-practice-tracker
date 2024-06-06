class Solution {
    public int trap(int[] height) {
        int trappedWater = 0;
        if(null == height || height.length < 1) return 0;

        int maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length-1;

        while(left < right) {
            if(height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                trappedWater += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                trappedWater += maxRight - height[right];
                right--;
            }
        }
        
        return trappedWater;
    }
}