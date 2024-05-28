class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void combinationSumHelper(int[] nums, int target, int start, List<List<Integer>> res, List<Integer> tempList) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=start; i<nums.length; i++) {
            tempList.add(nums[i]);
            combinationSumHelper(nums, target-nums[i], i, res, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}