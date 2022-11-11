class Solution {
    public List<List<Integer>> fourSum(int[] nums, int t) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < n - 3; i++) {
            for(int j = i + 1; j < n - 2; j++) {
                int k = j + 1;
                int l = n - 1;
                long sum1 = nums[i] + nums[j];
                while(k < l) {
                    long sum = sum1 + nums[k] + nums[l];
                    if(sum == t) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while(k < l && nums[k] == nums[k + 1]) k++;
                        while(k < l && nums[l] == nums[l - 1]) l--;
                        k++; l--;
                    }else if(t > sum) {
                        k++;
                    }else {
                        l--;
                    }
                }
                while(j < n - 3 && nums[j] == nums[j + 1]) j++;
            }
            while(i < n - 2 && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }
}