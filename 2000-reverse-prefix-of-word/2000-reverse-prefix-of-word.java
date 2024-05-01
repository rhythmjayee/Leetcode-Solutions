class Solution {
    private String reverse(int i, String s) {
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            sb.append(s.charAt(i--));
        }
        return sb.toString();
    }
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < word.length()) {
            if(word.charAt(i) == ch) {
                sb.append(reverse(i++, word));
                break;
            }
            i++;
        }
        while(i < word.length()) {
            sb.append(word.charAt(i++)+"");
        }
        String ans = sb.toString();
        return ans.length() == 0 ? word : ans;
    }
}