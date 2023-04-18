class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        int n = word1.length();
        int m = word2.length();
        StringBuilder sb = new StringBuilder();
        
        while(i < n || j < m) {
            if(i < n) {
                char a = word1.charAt(i++);
                 sb.append(a);
            }
            if(j < m) {
                char b = word2.charAt(j++);
                sb.append(b);
            }
        }
        return sb.toString();
    }
}