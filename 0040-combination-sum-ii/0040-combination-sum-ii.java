class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Util(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void combinationSum2Util(int[] nums, int target, int start, List<List<Integer>> res, List<Integer> tempList) {
        if(target < 0)
            return;
        
        if(target == 0)
            res.add(new ArrayList<>(tempList));
        
        int prev = -1;
        for(int i=start; i<nums.length; i++) {
            if(prev != nums[i]) {
                tempList.add(nums[i]);
                combinationSum2Util(nums, target - nums[i], i+1, res, tempList);
                tempList.remove(tempList.size()-1);
                prev = nums[i];
            }
        }
    }
}