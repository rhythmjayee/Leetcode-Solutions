class Solution {
    public String largestGoodInteger(String num) {
        int max = -1;
        int end = 0;
        while(end < num.length() - 2) {
            if(num.charAt(end) == num.charAt(end + 1) && num.charAt(end + 1) == num.charAt(end + 2)) {
                int dig = num.charAt(end) - '0';
                int curr = dig*100 + dig*10 + dig;
                max = Math.max(max, curr);
                end += 3;
            } else {
                end++;
            }
        }
        if(max == 0) return "000";
        return max == -1 ? "" : String.valueOf(max);
    }
}