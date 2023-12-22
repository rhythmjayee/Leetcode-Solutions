class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        int ones = 0;
        int zeros = 0;
        int max = 0;
        int n = s.length();
        for(char x : s.toCharArray()) {
            if(x - '0' == 1) totalOnes++;
        }
        for(int i = 0; i < n; i++) {
            int x = s.charAt(i) - '0';
            if(x == 0) {
                zeros++;
            } else ones++;
            
            if(zeros + ones < n)
                max = Math.max(max, zeros + totalOnes - ones);
            
        }
        return max;
    }
}