class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> {
            if(a[1] != b[1]) return a[1]-b[1];
            return a[0]-b[0];
        });
        
        int n = pairs.length; 
        int max = 1;
        int end = pairs[0][1];
        
        for(int i = 1; i<n; i++){
           if(pairs[i][0] > end){
               max++;
               end = pairs[i][1];
           }
        }
        
        return max;
    }
}