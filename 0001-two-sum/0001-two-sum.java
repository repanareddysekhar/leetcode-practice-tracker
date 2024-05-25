class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(null == nums || nums.length < 2)
            return new int[] {-1, -1};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int rem = target - nums[i];
            if(map.containsKey(rem)) {
                return new int[] {i, map.get(rem)};
            }
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}