class Solution {
    public int majorityElement(int[] nums) {
        // Intuition behind Moore voting algorithm
        // If an element is majority element, then it will remain in the lead even after encountering other elements

        int candidate = 0;
        int cnt = 0;

        for(int num : nums) {
            if(cnt == 0) {
                candidate = num;
            }

            if(candidate == num) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return candidate;
    }
}