class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList();
        int i = 0;
        for (int num : target) {
            //fill ans, as num is not there in target so we always need Push, Pop
            while (i < num - 1) {
                ans.add("Push");
                ans.add("Pop");
                i++;
            }
            //here we matched with target
            ans.add("Push");
            i++;
        }
        
        return ans;
    }
}