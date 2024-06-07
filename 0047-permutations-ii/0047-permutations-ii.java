class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(null == nums || nums.length < 1)
            return res;

        Arrays.sort(nums);

        helper(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] vis) {
        if(nums.length == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(vis[i]) continue;
            if(i>0 && !vis[i-1] && nums[i] == nums[i-1]) continue;

            vis[i] = true;
            temp.add(nums[i]);
            helper(nums, res, temp, vis);
            temp.remove(temp.size()-1);
            vis[i] = false;
        }
    }
}