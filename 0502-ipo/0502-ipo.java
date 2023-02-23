class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
      //MAx heap for profit 
       PriorityQueue<int[]> maxheap=new PriorityQueue<>((int[]a,int[]b)->{
         return b[1]-a[1];
      });
      //MIN heap for captial
      PriorityQueue<int[]> minheap = new PriorityQueue<>((int[]a,int[]b)->{
          return a[0]-b[0];
      });
      
      for(int i = 0; i < Profits.length; i++) {
          minheap.add(new int[]{Capital[i],Profits[i]});
      }

      int total = W;
      
      while(k-- >0){
         //add all projects in max heap for profit whose capital <= total
         while(!minheap.isEmpty() && minheap.peek()[0]<=total){
          maxheap.add(minheap.poll());
        }
        //no valid project break
        if(maxheap.isEmpty()) break;

        int p[] = maxheap.poll();
        total += p[1];
       
      }
      return total;
    }
}