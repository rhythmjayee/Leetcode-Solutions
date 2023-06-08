class Solution {
    public int countNegatives(int[][] g) {
        int count = 0;
        int m = g[0].length;
        int currRowNegativeIndex = m - 1;

        // Iterate on all rows of the matrix one by one.
        for (int[] row : g) {
            // Decrease 'currRowNegativeIndex' so that it points to current row's last positive element.
            while (currRowNegativeIndex >= 0 && row[currRowNegativeIndex] < 0) {
                currRowNegativeIndex--;
            }
            // 'currRowNegativeIndex' points to the last positive element,
            // which means 'n - (currRowNegativeIndex + 1)' is the number of all negative elements.
            count += (m - (currRowNegativeIndex + 1));
        }
        return count;
    }
}