class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> distances = new HashSet<>();
        distances.add(distance(p1, p2));
        distances.add(distance(p2, p3));
        distances.add(distance(p3, p4));
        distances.add(distance(p1, p4));
        distances.add(distance(p4, p2));
        distances.add(distance(p1, p3));

        return !distances.contains(0) && distances.size() == 2;
    }

    private Integer distance(int[] a, int[] b) {
        return ((a[0] - b[0])*(a[0] - b[0]) + (a[1]-b[1])*(a[1]-b[1]));
    }
}