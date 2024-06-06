class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        if(null == height || height.length < 1) return res;

        int start = 0, end = height.length-1;

        while(start < end) {
            res = Math.max(res, (end-start)*Math.min(height[start], height[end]));
            if(height[start] < height[end])
                start++;
            else
                end--;
        }

        return res;
    }
}