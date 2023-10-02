class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int i = 0;
        int a = 0;
        int b = 0;
        while(i < n) {
            char c = colors.charAt(i);
            int count = 0;
            while(i < n && c == 'A') {
                count++;
                i++;
                if(i < n) c = colors.charAt(i);
            }
            if(count > 2) a += (count - 2);
            count = 0;
            while(i < n && c == 'B') {
                count++;
                i++;
                if(i < n) c = colors.charAt(i);
            }
            if(count > 2) b += (count - 2);
        }
        return a > b;
    }
}

/**
AAAA


*/