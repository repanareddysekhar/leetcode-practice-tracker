class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == nums)
            return res;
        
        subsets(nums, res, 0, new ArrayList<>());
        return res;
    }

    private void subsets(int[] nums, List<List<Integer>> res, int start, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for(int i=start; i<nums.length; i++) {
            temp.add(nums[i]);
            subsets(nums, res, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}