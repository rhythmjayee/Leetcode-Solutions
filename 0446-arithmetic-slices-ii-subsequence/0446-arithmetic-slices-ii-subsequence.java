class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int re = 0;
        //map of array will store differrnt common diff at of seq ending at ith element
        //and the count of occurrance of different seq
        // i -> ([diff, count])
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        for(int i=0; i<A.length; i++) {
            maps[i] = new HashMap<>();
            int num = A[i];
            for(int j=0; j<i; j++) {
                //handling overflow cases
                if((long)num-A[j]>Integer.MAX_VALUE) continue;
                if((long)num-A[j]<Integer.MIN_VALUE) continue;
                
                int commonDiff = num - A[j];
                //for common diff
                int countOfSeqAtJ = maps[j].getOrDefault(commonDiff, 0);
                int countOfSeqAtI = maps[i].getOrDefault(commonDiff,0);
                    //seq will becomes at i
                    //seq from j + ith element
                    //seq of j with i elements --> 
                    //this will not count currently and will make seq for next elements
                maps[i].put(commonDiff, countOfSeqAtI + countOfSeqAtJ + 1);
                re += countOfSeqAtJ;
            }
        }
        return re;
    }
    
}