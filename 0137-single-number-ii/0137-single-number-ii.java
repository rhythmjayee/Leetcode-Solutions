class Solution {
  public int singleNumber(int[] nums) {
      int res = 0;
        //built the number by bits at each place
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int mask = 1 << i;
            //calc how many number have their ith bit on
            for (int n : nums) 
                if ((n & mask) != 0) 
                    sum++;
            //if didnt divided by 3 then single occured number has ith bit on
            if (sum % 3 == 1)
                res |= mask;
        }
        return res;
    }
}