class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        Integer f[] = new Integer[26];
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if(f[idx] == null) f[idx] = i;
            else {
                max = Math.max(max, i - f[idx] - 1);
            }
        }
        return max;
    }
}