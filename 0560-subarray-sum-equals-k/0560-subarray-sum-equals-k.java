class Solution {
    public int subarraySum(int[] nums, int k) {
        if(null == nums || nums.length < 1) return 0;

        int res = 0;
        int currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            currSum += num;
            if(currSum == k) res++;
            res += map.getOrDefault(currSum-k, 0);

            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }

        return res;
    }
}