class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, 0, ans, new StringBuilder());
        return ans;
    }
    private void helper(String s, int index, int count, List<String> ans, StringBuilder sb) {
        if(count == 4 && index == s.length()) {
            ans.add(sb.toString());
            return;
        }else if(index >= s.length()) return;
        
        int len = sb.length();
        for(int i = 1; i <= 3 && index + i <= s.length() ; i++) {
            StringBuilder sbb = new StringBuilder();
            String st = s.substring(index, index + i);
            int val = Integer.valueOf(st);
            
            if(st.length() == 2 && val < 10) return;
            else if(val > 255) return;
            
            sbb.append(st);
            if(sb.length() > 0)
                sb.append(".");
            sb.append(sbb);
            helper(s, index + i, count+1, ans, sb);
            sb.delete(len, len + st.length() + 1);
        }
    }
}