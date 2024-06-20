class Solution {
    public int romanToInt(String s) {
        if(null == s || s.length() < 1) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int i = 0;
        int sum = 0;

        while(i < s.length()-1) {
            int prev = map.get(s.charAt(i));
            int next = map.get(s.charAt(i+1));

            if(prev < next) {
                sum -= prev;
            } else {
                sum += prev;
            }
            i++;
        }

        sum += map.get(s.charAt(s.length()-1));

        return sum;
    }
}