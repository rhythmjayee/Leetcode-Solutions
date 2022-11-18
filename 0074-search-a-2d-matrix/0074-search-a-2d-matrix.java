class Solution {
    public boolean searchMatrix(int[][] mt, int t) {
        int n = mt.length;
        int m = mt[0].length;
        //As ele in last col i-1th row > first ele of ith row
        //and each row is sorted -> each row laid next to each other
        //and can be consider as a sorted array
        int i = 0;
        int j = n * m - 1;
        
        while(i <= j) {
            int mid = i + ((j - i) >> 1);
            //As each row starts after m elements
            int r = mid / m;
            //To get the col of ele in row "%" will always give col in [0, m-1]
            int c = mid % m;
            if(mt[r][c] == t) return true;
            else if(mt[r][c] < t) i = mid + 1;
            else j = mid - 1;
        }
        return false;
    }
}