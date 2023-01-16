class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> merge=new ArrayList<>();  
          if(intervals.length==0){
            merge.add(newInterval);
            return merge.toArray(new int[merge.size()][]);
          }
      int newStart=newInterval[0];
      int newEnd=newInterval[1];
      
      int i=0;
      while(i<intervals.length && intervals[i][1]<newStart){
        merge.add(new int[]{intervals[i][0],intervals[i][1]});
        i++;
      }
      
      while(i<intervals.length && intervals[i][0]<=newEnd){
        newStart=Math.min(newStart,intervals[i][0]);
        newEnd=Math.max(newEnd,intervals[i][1]);
        i++;
      }
       merge.add(new int[]{newStart,newEnd});
      
      while(i<intervals.length){
         merge.add(new int[]{intervals[i][0],intervals[i][1]});
        i++;
      }
      
      
        return  merge.toArray(new int[merge.size()][]);
    }
}