class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int window = s1.length(), length = s2.length();

        if(window > length) return false;
        
        int[] s1Hash = new int[26];
        int[] s2Hash = new int[26];
        int l = 0, r = 0;

        while(r < window) {
            s1Hash[s1.charAt(r) - 'a']++;
            s2Hash[s2.charAt(r++) - 'a']++;
        }
        r--;

        while(r< length) {
            if(allZeroes(s1Hash, s2Hash)) return true;

            r++;
            if(r != length)
                s2Hash[s2.charAt(r) - 'a']++;
            s2Hash[s2.charAt(l++) - 'a']--;
        }

        return false;
    }

    private boolean allZeroes(int[] tb1, int[] tb2) {
        for(int i=0; i<tb1.length; i++) {
            if(tb1[i] != tb2[i])
                return false;
        }
        return true;
    }
}