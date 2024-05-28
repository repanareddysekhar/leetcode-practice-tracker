class Solution {
    public int longestConsecutive(int[] nums) {
        if(null == nums || nums.length < 1) return 0;

        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        for(int num : nums) {
            if(!set.contains(num-1)) {
                int currNum = num;
                int currCnt = 1;

                while(set.contains(currNum + 1)) {
                    currNum++;
                    currCnt++;
                }

                res = Math.max(res, currCnt);
            }
        }

        return res;
    }
}