class Solution {
    public int minAddToMakeValid(String s) {
        int mv = 0;
        int sum = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                if(mv < 0) {
                    sum += Math.abs(mv);
                    mv = 0;
                }
                mv++;
            }
            else {
                mv--;
            }
        }
        return sum + Math.abs(mv);
    }
}