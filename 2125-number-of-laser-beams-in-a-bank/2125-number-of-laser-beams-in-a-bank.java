class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int beans = 0;
        int prev = 0;
        for(int i = 0; i < n; i++) {
            int securityDevices = 0;
            for(char c : bank[i].toCharArray()) {
                if(c == '1') securityDevices++;
            }
            if(prev > 0)
                beans += prev * securityDevices;
            if(securityDevices > 0)
                prev = securityDevices;
        }
        return beans;
    }
}