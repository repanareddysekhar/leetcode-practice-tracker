class Solution {
    public String reorganizeString(String s) {
        if(s == null || s.length() == 0) return "";

        int[] cnt = new int[26];
        int maxCount = 0, index=0;
        for(int i=0; i<s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++) {
            if(maxCount < cnt[i]) {
                index = i;
                maxCount = cnt[i];
            }
        }

        if(maxCount > (s.length()+1)/2) return "";

        int t = 0;
        char[] res = new char[s.length()];
        while(maxCount > 0) {
            res[t] = (char)(index + 'a');
            t += 2;
            maxCount--;
        }
        cnt[index] = 0;

        for(int i=0; i<26; i++) {
            while(cnt[i] > 0) {
                t = (t >= s.length()) ? 1 : t;
                res[t] = (char) (i + 'a');
                t += 2;
                cnt[i]--;
            }
        }

        return String.valueOf(res);
    }
}