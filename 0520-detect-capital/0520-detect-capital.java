class Solution {
    public boolean detectCapitalUse(String word) {
        int caps = 0;
        for(char c : word.toCharArray()) {
            int ascii = (int)(c);
            if(ascii < 97) caps++;
        }
        return caps == word.length()
            || caps == 0 || (caps == 1 && (int)(word.charAt(0)) < 97);
    }
}