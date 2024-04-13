class Solution {
    public int maximalRectangle(char[][] g) {
        int n = g.length;
        if(n == 0) return 0;
        int m = g[0].length;
        
        int maxReactangle = 0;
        int[] dp = new int[m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m;j++){
                if(g[i][j]-'0' == 0){//if curr col is 0 and dp[] has some value make it 0
                    dp[j] = 0;
                    continue;
                }
                dp[j] += g[i][j]-'0';
            }
            // for(int x : dp) System.out.print(x+" ");
            //  System.out.println();
            int area = largestRectangleAreaI(dp);
            maxReactangle = Math.max(maxReactangle,area);
        }
        
        return maxReactangle;
    }
    public int largestRectangleAreaI(int[] heights) {
        int n = heights.length;
        int leftS[] = new int[n];//stores left smaller
        int rightS[] = new int[n];//stores right smaller
        
        Deque<Integer> sk = new LinkedList<>();
        for(int i = 0; i<n; i++){
            while(!sk.isEmpty() && heights[sk.peek()]>=heights[i]){
                sk.pop();
            }
            if(sk.isEmpty()) leftS[i] = 0;
            else leftS[i] = sk.peek()+1;//left smaller index but index+1 will be start of rect
            sk.push(i);
        }
        sk.clear();
        for(int i = n-1; i>=0; i--){
            while(!sk.isEmpty() && heights[sk.peek()]>=heights[i]){
                sk.pop();
            }
            if(sk.isEmpty()) rightS[i] = n-1;
            else rightS[i] = sk.peek()-1; //same as above logic
            sk.push(i);
        }
        
        int maxA = 0;
        for(int i=0; i<n; i++){
            maxA = Math.max(maxA,heights[i]*(rightS[i]-leftS[i]+1));
        }
        return maxA;
    }
}