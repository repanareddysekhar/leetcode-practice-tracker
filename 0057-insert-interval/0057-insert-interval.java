class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[] temp  = newInterval;
        List<int[]> res = new ArrayList<>();

        for(int[] interval : intervals) {
            if(temp[1] < interval[0]) {
                res.add(temp);
                temp = interval;
            } else if(interval[1] < temp[0]) {
                res.add(interval);
            } else {
                temp[0] = Math.min(temp[0], interval[0]);
                temp[1] = Math.max(temp[1], interval[1]);
            }
        }

        res.add(temp);

        return res.toArray(new int[res.size()][]);
    }
}