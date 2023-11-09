class Solution {
    public int countHomogenous(String s) {
        int mod = (int)(1e9 + 7);
        long count = 0;
        int n = s.length();
        int i = 0;
        while(i < n) {
            int j = i;
            char c = s.charAt(j);
            while(j < n && c == s.charAt(j)) {
                j++;
            }
            long substrings = ((((long)(j - i) * (long)(j - i + 1))% mod) >> 1)% mod;
            count = (count + substrings)%mod;
            i = j;
        }
        return (int)(count % mod);
    }
}