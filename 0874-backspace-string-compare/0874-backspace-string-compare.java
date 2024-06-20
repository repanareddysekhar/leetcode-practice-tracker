class Solution {
    public boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));
    }

    private String process(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch != '#') {
                sb.append(ch);
            } else if(sb.length() > 0) {
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}