class Solution {
    public String frequencySort(String s) {
        if(null == s || s.length() < 1) return s;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue());
        
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : map.entrySet())
            pq.add(entry);
        
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            for(int i=0; i<entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}