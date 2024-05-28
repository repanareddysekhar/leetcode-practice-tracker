class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if(null == s || null == p) return res;

        int window = p.length(), length = s.length();

        if(window > length) return res;

        int[] sHash = new int[26];
        int[] pHash = new int[26];
        int left = 0, right = 0;

        while(right < window) {
            sHash[s.charAt(right) - 'a']++;
            pHash[p.charAt(right++) - 'a']++;
        }
        right--;

        while(right < length) {
            if(areSameHash(sHash, pHash))
                res.add(left);

            right++;
            if(right != length)
                sHash[s.charAt(right) - 'a']++;
            
            sHash[s.charAt(left++) - 'a']--;
        }

        return res;
    }

    private boolean areSameHash(int[] tb1, int[] tb2) {
        for(int i=0; i<tb1.length; i++) {
                if(tb1[i] != tb2[i])
                    return false;
        }
        return true;
    }
}