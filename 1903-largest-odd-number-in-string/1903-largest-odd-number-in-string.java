class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int j = n - 1;
        while(j >= 0) {
            int x = num.charAt(j) - '0';
            if(x % 2 != 0) break;
            j--;
        }
        int i = 0;
        while(i <= j && num.charAt(i) == '0') {
            i++;
        }
        
        return j < 0 ? "" : num.substring(i, j + 1);
    }
}