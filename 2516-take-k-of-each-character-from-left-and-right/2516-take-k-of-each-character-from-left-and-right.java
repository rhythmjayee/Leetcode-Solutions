class Solution {
    public int takeCharacters(String st, int k) {
        int ans = Integer.MAX_VALUE;
        int s = 0;
        int[] f = new int[3];
        for(char c : st.toCharArray()) {
            f[c - 'a']++;
        }
        if(f[0] < k || f[1] < k || f[2] < k) return -1;
        int n = st.length();
        for(int e = 0; e<n; e++) {
            char c = st.charAt(e);
            f[c - 'a']--;
            while(s <= e && (f[0] < k || f[1] < k || f[2] < k)) {
                char cc = st.charAt(s++);
                f[cc - 'a']++;
            }
            ans = Math.min(ans, n - (e - s + 1));
        }
        return ans;
    }
}