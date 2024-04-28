class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        int skip = 1;
        while(i <= j) {
            int a = s.charAt(i);
            int b = s.charAt(j);
            if(a != b) break;
            i++;
            j--;
        }
        if(j <= i && (n & 1) != 0) return true;
        int i2 = i + 1;
        int j2 = j;
        while(i2 <= j2) {
            int a = s.charAt(i2);
            int b = s.charAt(j2);
            if(a != b) break;
            i2++;
            j2--;
        }
        if(j2 <= i2) return true;
        i2 = i;
        j2 = j - 1;
        while(i2 <= j2) {
            int a = s.charAt(i2);
            int b = s.charAt(j2);
            if(a != b) return false;
            i2++;
            j2--;
        }
        
        return true;
    }
}