class Solution {
    public String convert(String s, int numRows) {
       /*
       PAY PALISHIRING  length = 14  r = 3 
       */ 
        if(s.length() < numRows || numRows == 1) return s;
        
        StringBuilder[] sb = new StringBuilder[numRows];
        int i = 0;
        for(i = 0; i<numRows; i++) {
            sb[i] = new StringBuilder(s.charAt(i)+"");
        }
        int idx = numRows - 2;
        int dir = 1;//up = 1 down = -1
        for(; i<s.length(); i++) {
            if(dir == 1 && idx >= 0) {
                sb[idx].append(s.charAt(i)+"");
                idx--;
                if(idx < 0) {
                    dir = -1;
                    idx = 1;
                }
            }else if(dir == -1 && idx < numRows) {
                sb[idx].append(s.charAt(i)+"");
                idx++;
                if(idx == numRows) {
                    dir = 1;
                    idx = numRows - 2;
                }
            }
        }
        
        for(i = 1; i<numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}