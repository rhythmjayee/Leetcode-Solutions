class Solution {
    public String reverseVowels(String s) {
        int[] v = new int[256];
        v[(int)('a')] = 1;
        v[(int)('e')] = 1;
        v[(int)('i')] = 1;
        v[(int)('o')] = 1;
        v[(int)('u')] = 1;
        v[(int)('A')] = 1;
        v[(int)('E')] = 1;
        v[(int)('I')] = 1;
        v[(int)('O')] = 1;
        v[(int)('U')] = 1;
        
        int n = s.length();
        int i = 0;
        int j = n - 1;
        char[] ch = s.toCharArray();
        
        while(i < j) {
            char c = s.charAt(i);
            while(i < j && v[(int)(c)] == 0) {
                c = s.charAt(++i);
            }
            if(i >= j) break;
            c = s.charAt(j);
            while(j > i && v[(int)(c)] == 0) {
                c = s.charAt(--j);
            }
            if(i >= j) break;
            swap(ch, i, j);
            i++; j--;
        }
        return String.valueOf(ch);
    }
    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}