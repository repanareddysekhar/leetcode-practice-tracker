class Solution {
    public int scheduleCourse(int[][] courses) {
        /**
        1. Sort courses by the end date, this way, when we're iterating through the courses, we can switch
        out any previous course with the current one without worrying about end date.

        2. Next, we iterate through each course, if we have enough days, we'll add it to our priority
        queue. If we don't have enough days, then we can either
        ignore this course OR We can replace this course with the longest course we added earlier.
         */

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int time = 0;

        for(int[] c : courses) {
            time += c[0];
            pq.add(c[0]);
            if(time > c[1])
                time -= pq.poll();
        }

        return pq.size();
    }
}