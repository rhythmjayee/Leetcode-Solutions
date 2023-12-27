class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTimeOfBalloons = 0;
        int totalTimeOfReamingBalloons = 0;
        int i = 0;
        int n = colors.length();
        
        while(i < n) {
            char c = colors.charAt(i);
            int j = i;
            int maxTime = 0;//represent balloon that will remain on rope
            while(j < n && c == colors.charAt(j)) {
                totalTimeOfBalloons += neededTime[j];
                maxTime = Math.max(maxTime, neededTime[j]);
                j++;
            }
            totalTimeOfReamingBalloons += maxTime;
            i = j;
        }
        return totalTimeOfBalloons - totalTimeOfReamingBalloons;
    }
}