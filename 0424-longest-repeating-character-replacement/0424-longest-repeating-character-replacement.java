class Solution {
    public int characterReplacement(String s, int k) {
        if(null == s || s.length() < 1 || k < 0) return 0;

        int[] hash = new int[26];
        int l = 0, r = 0;
        int res = 0;
        int maxf = 0;

        for(r=0; r<s.length(); r++) {
            hash[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, hash[s.charAt(r) - 'A']);

            //check if window is valid or not
            if(r - l + 1 - maxf > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}