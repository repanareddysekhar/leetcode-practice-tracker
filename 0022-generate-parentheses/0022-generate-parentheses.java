class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if(n < 1)
            return res;
        generateParenthesis(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void generateParenthesis(int n, int open, int close, StringBuilder sb, List<String> res) {
        if(2*n == sb.length()) {
            res.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append("(");
            generateParenthesis(n, open+1, close, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open) {
            sb.append(")");
            generateParenthesis(n, open, close+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}