class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        // Iterate on all rows of the matrix one by one.
        for (int[] row : grid) {
            // Using binary search find the index
            // which has the first negative element.
            int left = 0, right = n;
            while (left < right) {
                int mid = (right + left) / 2;
                if (row[mid] < 0) {
                    right = mid;
                } else {
                    left = mid + 1;  
                }
            }
            // 'left' points to the first negative element,
            // which means 'n - left' is the number of all negative elements.
            count += (n - right);
        }
        return count;
    }
}