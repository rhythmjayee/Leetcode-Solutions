class Solution {
     public int[] productQueries(int n, int[][] qu) {
        String str = Integer.toBinaryString(n); // convert n into binary string to get  minimum number of powers of  2
        ArrayList<Long> list = new ArrayList<>();
        long pow = 1;
        for (int i = str.length() - 1; i >= 0; i--) { // now loop on binary string
            if (str.charAt(i) == '1') list.add(pow); //if i'th bit is set add its power to our list
            pow = pow * 2;
        }
        long mod = (long) 1e9 + 7;

        int ans[] = new int[qu.length];

        for (int i = 0; i < qu.length; i++) {
            long mul = 1;
            for (int j = qu[i][0]; j <= qu[i][1]; j++) { //compute answer for each query
                mul = (mul * list.get(j)) % mod;
            }

            ans[i] = (int) mul;
        }

        return ans;
    }
}