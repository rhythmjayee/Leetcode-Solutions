class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        //element may be in front, middle, end
        int[] candidates = {arr[n / 4], arr[n / 2], arr[3 * n / 4]};
        int target = n / 4;
        
        for (int candidate : candidates) {
            //for each candidate get lower, upper bound to count the freq
            int left = lower_bound(arr, candidate);
            int right = upper_bound(arr, candidate);
            //[1,2,2,6,6,6,6,7,10]
            //left will on index 2, right on index 7
            if (right - left - 1 > target) {
                return candidate;
            }
        }
        
        return -1;
    }
    
    public int upper_bound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
    
    public int lower_bound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}