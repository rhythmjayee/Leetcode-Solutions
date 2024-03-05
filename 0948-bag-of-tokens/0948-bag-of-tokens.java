class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        
        int scr = 0;
        int max = 0;
        while(i <= j) {
            if(power >= tokens[i]) {
                power -= tokens[i];
                scr++;
                max = Math.max(max, scr);
                i++;
            } else if(scr >= 1) {
                power += tokens[j];
                scr--;
                j--;
            } else break;
        }
        return max;
    }
}