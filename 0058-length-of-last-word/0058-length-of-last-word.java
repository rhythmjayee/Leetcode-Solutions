class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int st = -1;
        int e = -1;
        int i = n-1;
        
        while(i >= 0 && s.charAt(i) == ' ') i--;
        e = i;
        while(i >= 0 && s.charAt(i) != ' ') i--;
        st = i + 1;
        
        return e - st + 1;
    }
}