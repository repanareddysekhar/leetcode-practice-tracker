class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if((null == nums) || (nums.length < 1) || (nums.length < k))
            return new int[0];
        
        int n = nums.length;
        int[] res = new int[n-k+1];
        LinkedList<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            if(!q.isEmpty() && q.peek() == i-k)
                q.poll();
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            
            q.offer(i);
            if(i+1 >= k)
                res[i+1-k] = nums[q.peek()];
        }

        return res;
    }
}