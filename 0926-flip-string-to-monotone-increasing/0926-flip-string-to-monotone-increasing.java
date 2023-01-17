class Solution {
    public int minFlipsMonoIncr(String s) {
        int z = 0;
        int o = 0;
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '0') z++;
            else o++;
        }
        int cz = 0;
        int co = 0;
        //inital min flips will be count of ones
        int ans = o;
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '1') {
                //for each one, we try to flip all next zeros to ones
                //and all before zeros to ones
                ans = Math.min(ans, co + z - cz);
                co++;
            } else {
                cz++;
            }
        }
        return ans;
    }
}