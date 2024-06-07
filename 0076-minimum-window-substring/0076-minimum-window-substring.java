class Solution {
    public String minWindow(String s, String t) {
        if(null == s || null == t || s.length() < 1 || t.length() < 1 || s.length() < t.length())
            return new String();
        
        int[] map = new int[128];
        int cnt = t.length();

        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;

        for(char ch : t.toCharArray())
            map[ch]++;
        
        char[] chS = s.toCharArray();

        while(end < chS.length) {
            if(map[chS[end++]]-- > 0)
                cnt--;
            
            while(cnt == 0) {
                if(end - start < minLen) {
                    minLen = end - start;
                    startIndex = start;
                }
                if(map[chS[start++]]++ == 0)
                    cnt++;
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
    }
}