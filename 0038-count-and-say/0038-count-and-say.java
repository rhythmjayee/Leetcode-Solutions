class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String ans = countAndSay(n - 1);
        
        int i = 0; 
        int l = ans.length();
        StringBuilder sb = new StringBuilder();
        while(i < l) {
            int d = ans.charAt(i) - '0';
            int count = 1;
            int j = i + 1;
            while(j < l && ans.charAt(j) - '0' == d) {
                count++;
                j++;
            }
            sb.append(count);
            sb.append((char)(d + '0'));
            i = count == 1 ? ++i : j;
        }
        return sb.toString();
    }
}