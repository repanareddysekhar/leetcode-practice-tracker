class Solution {
    public int[][] merge(int[][] intervals) {
        if(null == intervals || intervals.length < 1 || intervals[0].length < 1) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] newInterval = intervals[0];
        ArrayList<int[]> res = new ArrayList<>();
        res.add(newInterval);

        for(int[] interval : intervals) {
            if(newInterval[1] >= interval[0]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                res.add(newInterval);
            }
        }


        return res.toArray(new int[res.size()][]);
    }
}