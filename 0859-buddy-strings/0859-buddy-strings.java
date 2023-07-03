class Solution {
    public char[] getChars(String s, String goal, int[] ij) {
        while(ij[0] < s.length() && ij[1] < goal.length() && s.charAt(ij[0]) == goal.charAt(ij[1])) {
            ij[0]++;
            ij[1]++;
        }
        if(ij[0] == s.length() || ij[1] == goal.length()) return new char[]{'0', '0'};
        return new char[]{s.charAt(ij[0]++),  goal.charAt(ij[1]++)};
    }
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            // If we have 2 same characters in string 's',
            // we can swap them and still the strings will remain equal.
            int[] frequency = new int[26];
            for (char ch : s.toCharArray()) {
                frequency[ch - 'a'] += 1;
                if (frequency[ch - 'a'] == 2) {
                    return true;
                }
            }
            // Otherwise, if we swap any two characters, it will make the strings unequal.
            return false;
        }
        int[] ij = new int[2];
        char[] ch1 = getChars(s, goal, ij);
        char[] ch2 = getChars(s, goal, ij);
        if(ch2[0] == '0' || (ch1[1] != ch2[0] || ch1[0] != ch2[1])) return false;
        char[] ch3 = getChars(s, goal, ij);
        if(ch3[0] != '0') return false;
        return true;
    }
}