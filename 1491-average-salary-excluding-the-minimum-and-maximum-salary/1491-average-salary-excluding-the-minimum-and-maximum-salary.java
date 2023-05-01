class Solution {
    public double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        
        for(int x : salary){
            max = Math.max(max,x);
            min = Math.min(min,x);
        }
        int c = 0;
        int s = 0;
        for(int x : salary){
            if(x != max && x != min){
                c++;
                s += x;
            }
        }
        
        return s/(double)c;
    }
}