class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> dist(b) - dist(a));

        for(int[] point : points) {
            pq.add(point);

            if(pq.size() > k)
                pq.poll();
        }

        ArrayList<int[]> res = new ArrayList<>();
        for(int i=0; i<k; i++) {
            res.add(pq.poll());
        }

        return res.toArray(new int[res.size()][]);
    }

    private int dist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }
}