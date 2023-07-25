class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while(i <= j) {
            int md = i + ((j - i) >> 1);
            if(md < n && md > 0 && arr[md] > arr[md + 1] &&
               arr[md - 1] < arr[md]) return md;
            else if(md < n && arr[md] < arr[md + 1]) {
                i = md + 1;
            }else {
                j = md - 1;
            }
        }
        return -1;
    }
}