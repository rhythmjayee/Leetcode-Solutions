class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[nums.length + 1];

        List<List<Integer>> ans = new ArrayList<>();
        for (int c : nums) {
            //add new list for number c, as no. of lists <= freq of c
            if (++freq[c] > ans.size()) {
                ans.add(new ArrayList<>());
            }

            // Store the integer in the list corresponding to its current frequency.
            ans.get(freq[c] - 1).add(c);
        }

        return ans;
    }
}