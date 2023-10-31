class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] ans = new int[n];
        int xor = 0;
        
        ans[0] = pref[0];
        xor = ans[0];
        for(int i = 1; i<n; i++){
            int num = 0;
            //for each each jth bit
            for(int j = 0 ; j<31; j++){
                //pref[i] has jth bit on & xor till now has jth bit off -> num must have jth bit on
                if((pref[i] & (1 << j)) != 0 && (xor & (1 << j)) == 0){
                    num = num | (1 << j);
                 //pref[i] has jth bit off & xor till now has jth bit on -> num must have jth bit on
                }else if((pref[i] & (1 << j)) == 0 && (xor & (1 << j)) != 0){
                     num = num | (1 << j);
                }
            }
            xor ^= num;
            ans[i] = num;
        }
        return ans;
    }
}

/*
5 ^ x = 2
5 = 0101
2 = 0010
OR = 0111

3 = 0011
3 ^ x = 1
1 = 0001

*/