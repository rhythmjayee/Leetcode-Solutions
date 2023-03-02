class Solution {
    public int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        int n = chars.length;
        int i = 0;//for traversing the chars for compression
        int j = 0;//for adding compressed string chrs
        
        while(i < n) {
            char c = chars[i];
            int count = 0;
            while(i < n && c == chars[i]) {
                count++;
                i++;
            }
            if(count == 1) {
                s.append(c);
            }else {
                s.append(c);
                s.append(count);
            }
            String st = s.toString();
            while(j < st.length()) {
                chars[j] = st.charAt(j++);
            }
        }
        return j;
    }
}