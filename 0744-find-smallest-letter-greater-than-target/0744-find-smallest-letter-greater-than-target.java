class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target == 'z') return letters[0];
        int min = 26;
        for(char c : letters) {
            if(c != target && target < c) {
                min = Math.min(min, c - 'a');
            }
        }
        return min == 26 ? letters[0] : (char)(min + 'a');
    }
}