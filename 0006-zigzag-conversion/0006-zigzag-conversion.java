class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;

        List<StringBuilder> list = new ArrayList<>();
        for(int i=0; i<numRows; i++)
            list.add(new StringBuilder());
        
        int curPos = 0;
        while(curPos < s.length()) {
            for(int i=0; i<numRows && curPos < s.length(); i++, curPos++) {
                list.get(i).append(s.charAt(curPos));
            }

            for(int i=numRows-2; i>0 && curPos < s.length(); i--, curPos++) {
                list.get(i).append(s.charAt(curPos));
            }
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list) {
            res.append(sb);
        }

        return res.toString();
    }
}