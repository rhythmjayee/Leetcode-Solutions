class Solution {
    public int countPalindromicSubsequence(String s) {
        //get first & last index of character
        //try to make Palindrome with fixing each char on first & last position
        //and then fix any other char bw them
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (first[curr] == - 1) {
                first[curr] = i;
            }
            
            last[curr] = i;
        }
        
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }
            //get all unique char seen
           int[] seen = new int[26];
            int count = 0;
            for (int j = first[i] + 1; j < last[i]; j++) {
                int idx = s.charAt(j) - 'a';
                if(seen[idx] == 0) {
                    seen[idx]++;
                    count++;
                }
            }
            
            ans += count;
        }
        
        return ans;
    }
}