class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int m = bank[0].length();
        int beans = 0;
        int prev = 0;
        for(int i = 0; i < n; i++) {
            int securityDevices = 0;
            for(int j = 0; j < m; j++) {
                char c = bank[i].charAt(j);
                if(c == '1') securityDevices++;
            }
            if(securityDevices > 0) {
                beans += prev * securityDevices;
                prev = securityDevices;
            }
                
        }
        return beans;
    }
}