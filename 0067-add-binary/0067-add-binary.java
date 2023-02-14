class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while(i >= 0 || j >= 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0; 
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            if(sum <= 1) {
                carry = 0;
                ans.append(sum+"");
            }else if(sum == 2) {
                carry = 1;
                ans.append(0+"");
            }else if(sum == 3) {
                carry = 1;
                ans.append(1+"");
            }
            i--;
            j--;
        }
        
        if(carry == 1) {
            ans.append(1+"");
        }
        
        return ans.reverse().toString();
    }
}