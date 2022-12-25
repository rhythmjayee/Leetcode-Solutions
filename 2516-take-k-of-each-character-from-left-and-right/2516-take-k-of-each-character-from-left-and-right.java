class Solution {
    public int takeCharacters(String st, int k) {
        int ans = Integer.MAX_VALUE;
        int s = 0;
        int[] f = new int[3];
        //get count of all the chars
        for(char c : st.toCharArray()) {
            f[c - 'a']++;
        }
        if(f[0] < k || f[1] < k || f[2] < k) return -1;
        int n = st.length();
        for(int e = 0; e<n; e++) {
            char c = st.charAt(e);
            //make a discarded window -> other than remaing window which is the ans
            f[c - 'a']--;
            //f[0] >= k && f[1] >= k && f[2] >= k
            //if any of the conditions fails -> 
            //decerease the discarded window from front by s++
            while(s <= e && (f[0] < k || f[1] < k || f[2] < k)) {
                char cc = st.charAt(s++);
                f[cc - 'a']++;
            }
            //Condition satifies -> remaing window may be the ans
            ans = Math.min(ans, n - (e - s + 1));
        }
        return ans;
    }
}