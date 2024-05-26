class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(null == s || s.length() < 1) return 0;

        int l = 0;
        int r = 0;
        int res = 0;

        HashSet<Character> set = new HashSet<>();

        while(r < s.length()) {
            if(!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }

        return res;
    }
}