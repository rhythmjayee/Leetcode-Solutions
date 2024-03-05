class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while(i < j) {
            char front = s.charAt(i);
            char back = s.charAt(j);
            if(front != back) break;
            while(i <= j && front == s.charAt(i)) {
                i++;
            }
            while(j >= i && back == s.charAt(j)) {
                j--;
            }
        }
        return j < i ? 0 : j - i + 1;
    }
}