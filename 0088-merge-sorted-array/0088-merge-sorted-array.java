class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while(k >= 0) {
            int n1 = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
            int n2 = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
            if(n1 >= n2) {
                nums1[k--] = n1;
                i--;
            }else {
                nums1[k--] = n2;
                j--;
            }
        }
    }
}