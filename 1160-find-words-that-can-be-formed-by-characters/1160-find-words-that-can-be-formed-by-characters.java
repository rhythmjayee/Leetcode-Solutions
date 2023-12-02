class Solution {
    public int[] formFeqArr(String chars) {
        int[] f = new int[26];
        for(char c : chars.toCharArray()) {
            f[c - 'a']++;
        }
        return f;
    }
    public boolean compareFreqArr(int[] f1, int[] f2) {
        for(int i = 0; i<26; i++) {
            if(f2[i] < f1[i]) return false;
        }
        return true;
    }
    public int countCharacters(String[] words, String chars) {
        int[] freq = formFeqArr(chars);
        int sum = 0;
        for(String w : words) {
            int[] f = formFeqArr(w);
            boolean isGood = compareFreqArr(f, freq);
            if(isGood) sum += w.length();
        }
        return sum;
    }
}