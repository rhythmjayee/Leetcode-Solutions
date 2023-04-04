class Solution {
    public int partitionString(String s) {
        int count = 1;
        int mask = 0;
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            int bitPosition = (1 << (c - 'a'));
            if((mask & bitPosition) != 0) {
                count++;
                mask = 0;
            }
            mask |= bitPosition;
        }
        return count;
    }
}