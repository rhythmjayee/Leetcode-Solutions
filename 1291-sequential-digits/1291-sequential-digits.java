class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        q.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
        
        while(!q.isEmpty()){
            int num = q.poll();
            if(num > high) break;
            if(num >= low && num <= high) res.add(num);
            
            int x = num%10;
            if(x < 9) {
                int n = num*10 + (x+1);
                q.add(n);
            }
        }
        return res;
    }
    
}