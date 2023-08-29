class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] open = new int[n + 1];
        int[] close = new int[n + 1];
        int min = Integer.MAX_VALUE;
        int idx = -1;
        
        for(int i = 1; i <= n; i++) {
            open[i] = open[i - 1];
            //calc no. of customer dont come till ith hour
            //and shop was open
            if(customers.charAt(i - 1) == 'N') open[i]++;
        }
        for(int i = n - 1; i >= 0; i--) {
            close[i] = close[i + 1];
            //calc no. of customer come till ith hour
            //and shop was closed
            if(customers.charAt(i) == 'Y') close[i]++;
        }
        
        for(int i = 0; i<=n; i++) {
            int los = open[i] +  (i < n ? close[i + 1] : 0);
            //if shop is closed at ith, check if any customer came at ith
            if(i < n && customers.charAt(i) == 'Y') los++;
            
            if(min > los) {
                min = los;
                idx = i;
            }
        }
        return idx;
    }
}