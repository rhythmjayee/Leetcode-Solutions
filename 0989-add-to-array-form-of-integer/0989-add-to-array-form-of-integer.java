class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int i = num.length - 1;
        int carry = 0;
        while(i >= 0 || k > 0) {
            int sum = (i < 0 ? 0 : num[i]) + (k > 0 ? k % 10 : 0) + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            i--;
            k /= 10;
        }
        if(carry != 0) {
            ans.add(carry);
        } 
        Collections.reverse(ans);
        return ans;
    }
}