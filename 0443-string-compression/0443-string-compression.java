class Solution {
    public int compress(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            char ch = chars[i];
            int groupLength = 0;
            while (i < chars.length && chars[i] == ch) {
                groupLength++;
                i++;
            }
            chars[res++] = ch;
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }
        return res;
    }
}