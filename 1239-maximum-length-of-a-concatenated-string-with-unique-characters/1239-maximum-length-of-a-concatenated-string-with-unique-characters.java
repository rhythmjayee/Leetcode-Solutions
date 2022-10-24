class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        int[][] f = new int[n][26];
        Set<Integer> skp = new HashSet<>();
        
        for(int i = 0; i<n; i++) {
            String s = arr.get(i);
            int nt = 0;
            for(int j = 0; j < s.length(); j++) {
                f[i][s.charAt(j) - 'a']++;
                if(f[i][s.charAt(j) - 'a'] > 1) {
                    nt = 1;
                    break;
                }
            }
            if(nt == 1) skp.add(i);
        }
        
        int max = get(arr, f, 0, new int[26], skp);
        return max;
    }
    private int get(List<String> arr, int[][] f, int i, int[] m, Set<Integer> skp) {
        if(i == arr.size()) return 0;
        
        int take = 0;
        int[] nf = isValid(f[i], m);
        int notTake = 0;
        if(!skp.contains(i) && nf.length != 0) {
            take = arr.get(i).length() + get(arr, f, i + 1, nf, skp);
        }
        notTake = get(arr, f, i + 1, m, skp);
        
        return Math.max(take, notTake);
    }
    private int[] isValid(int[] a, int[] b) {
        int[] nf = new int[26];
        for(int i = 0; i < 26; i++) {
            if(a[i] != 0 && b[i] != 0) return new int[0];
            nf[i] = a[i] + b[i];
        }
        return nf;
    }
}