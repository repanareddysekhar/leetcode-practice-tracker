class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(null == nums || nums.length < 1)
            return res;
        
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void subsetsWithDup(int[] nums, int start, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));

        for(int i=start; i<nums.length; i++) {
            if(i!=start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            subsetsWithDup(nums, i+1, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}