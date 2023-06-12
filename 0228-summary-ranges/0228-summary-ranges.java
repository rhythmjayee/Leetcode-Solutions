class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        
        while(i < n) {
            int start = nums[i];
            while(i < n - 1 && nums[i] - nums[i + 1] == -1) {
                i++;
            }
            if(start != nums[i]) {
                ls.add((start+"->"+nums[i]));
            }else {
                ls.add(String.valueOf(start));
            }
            i++;
        }
        return ls;
    }
}