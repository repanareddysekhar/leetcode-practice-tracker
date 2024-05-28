class Solution {
    public String longestPalindrome(String s) {
        if(null == s || s.length() < 1) return s;

        int maxLengthPal = 0;

        int n = s.length(), low, high, start = 0;

        for(int i=0; i<n; i++) {
            low = i-1;
            high = i+1;

            while(high < n && s.charAt(high) == s.charAt(i)) high++;
            while(low >= 0 && s.charAt(low) == s.charAt(i)) low--;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            if(high - low - 1 > maxLengthPal) {
                start = low + 1;
                maxLengthPal = high - low - 1;
            }

        }

        return s.substring(start, start + maxLengthPal);
    }
}