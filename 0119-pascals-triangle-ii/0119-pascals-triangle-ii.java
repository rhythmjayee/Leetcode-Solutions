class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        if(rowIndex == 0) {
            return tmp;
        } else if(rowIndex == 1) {
            tmp.add(1);
            return tmp;
        }
        tmp.add(1);
        
        for(int i = 2; i <= rowIndex; i++) {
            int n = tmp.size();
            List<Integer> ntmp = new ArrayList<>();
            ntmp.add(1);
            for(int j = 0; j < n - 1; j++) {
                ntmp.add(tmp.get(j) + tmp.get(j + 1));
            }
            ntmp.add(1);
            tmp = ntmp;
        }
        return tmp;
    }
}