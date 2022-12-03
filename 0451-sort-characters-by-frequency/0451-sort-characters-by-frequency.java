class Solution {
    public String frequencySort(String s) {
        int[] f = new int[256];
        for(char c : s.toCharArray()) {
            f[(int)c]++;
        }
        int n = s.length();
        List<Integer> a[] = new ArrayList[n + 1];
        for(int i = 0; i < 256; i++) {
            int x = f[i];
            if(x != 0) {
                if(a[x] == null) a[x] = new ArrayList<>();
                a[x].add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = n; i>=1; i--) {
            if(a[i] != null) {
                //get all the chars which occur i times
                for(int x : a[i]) {
                    char c = (char)(x);
                    //add char c, i times
                    for(int j = 0; j<i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}