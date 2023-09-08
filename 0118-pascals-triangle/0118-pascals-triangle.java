class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(new Integer[]{1}));

        for(int i = 1; i<numRows; i++){
            List<Integer> prev = res.get(i-1);
            List<Integer> ls = new ArrayList<>();
            ls.add(1);
            for(int j = 1; j<prev.size(); j++){
                ls.add(prev.get(j-1)+prev.get(j));
            }
            ls.add(1);
            res.add(ls);
        }
        return res;
    }
}