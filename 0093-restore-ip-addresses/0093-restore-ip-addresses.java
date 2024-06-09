class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, 0, 0, "");
        return res;
    }

    void restoreIpAddresses(String s, int index, int cnt, String path) {
        if(cnt > 4) return;
        if(cnt == 4 && index >= s.length()) {
            res.add(path.substring(0, path.length()-1));
            return;
        }

        for(int i=1; i<=3 && index + i <= s.length(); i++) {
            String num = s.substring(index, index+i);
            if(num.charAt(0) == '0' && i!=1) break;
            else if(Integer.parseInt(num) <= 255) {
                restoreIpAddresses(s, index+i, cnt+1, path + num + ".");
            }
        }
    }
}