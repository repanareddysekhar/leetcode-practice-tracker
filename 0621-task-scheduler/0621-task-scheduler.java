class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c : tasks)
            map[c - 'A']++;

         Arrays.sort(map);
         int maxFreq = map[25];

         int idle = (maxFreq - 1) * n;

         for(int i=map.length-2; i>=0 && idle>0; i--) {
            idle -= Math.min(map[i], maxFreq-1);
         }

         return tasks.length + Math.max(idle, 0);
    }
}