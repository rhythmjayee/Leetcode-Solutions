class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        
        int max = Integer.MIN_VALUE , sum = 0;
        
        for(int i = 0; i<n; i++){
            max = Math.max(max,weights[i]);
            sum += weights[i];
        }
        
        int start = max;//min cap of ship should be the max of weights
        int end = sum;//max cap will the the sum of weights
        
        while(start < end){
            int shipCap = start + ((end - start)>>1);
            
            int minDaysToShipWithCurrCap = getDays(weights,shipCap);
            
            if(minDaysToShipWithCurrCap > days){
                start = shipCap + 1;
            }else{
                end = shipCap;
            }
            
        }
        
        return start;
    }
    
    public int getDays(int[] a,int cap){
        int days = 1;
        int n = a.length;
        int w = cap;
        for(int i=0; i<n; ){
             if(w >= a[i]){
                w -= a[i];
                i++;
            }else{
                days++;
                w = cap;
            }
        }
        
        return days;
    }
}