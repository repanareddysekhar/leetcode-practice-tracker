class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == nums)
            return res;
        
        permute(nums, res, new ArrayList<>());
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, List<Integer> temp) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            permute(nums, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}