class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> ls = new ArrayList<>();
        for(int x : candies) max = Math.max(max, x);
        for(int x : candies) {
            if(x + extraCandies >= max) {
                ls.add(true);
            }else ls.add(false);
        }
        return ls;
    }
}