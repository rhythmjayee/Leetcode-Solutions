class Solution {
      public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length; 
        int low = 0, high = n1;
        
        while(low <= high) {
            //cut on nums1
            int cut1 = (low + high) >> 1;
            //handles case for total odd no. of elements
            //cut on nums2
            int cut2 = (n1 + n2 + 1) / 2 - cut1; 
            
            //left -> represent last element of left part when arr got cutted
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1]; 
            //right -> represent first element of right part when arr got cutted
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2]; 
            
            
            if(left1 <= right2 && left2 <= right1) {
                //even elements case
                if( (n1 + n2) % 2 == 0 ) 
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0; 
                else 
                    return Math.max(left1, left2); 
            }
            //left part of nums1 has greater element than right part of nums2
            //lower the cut
            else if(left1 > right2) {
                high = cut1 - 1; 
            }
            else {
                low = cut1 + 1; 
            }
        }
        return 0.0; 
    }
}