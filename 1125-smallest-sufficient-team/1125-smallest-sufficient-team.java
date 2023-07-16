class Solution {
    Long[] dp;
    Map<Integer, Integer> peopleSkillMap;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillsMap = new HashMap<>();
        peopleSkillMap = new HashMap<>();
        int n = req_skills.length;
        int m = people.size();
        int skillsMask = (1 << n) - 1;
        
        for(int i = 0; i<n; i++) {
            skillsMap.put(req_skills[i], i);
        }
        for(int i = 0; i<m; i++) {
            int peopleSkillsMask = 0;
            for(String skill : people.get(i)) {
                peopleSkillsMask = (peopleSkillsMask | (1 << skillsMap.get(skill)));
            }
            peopleSkillMap.put(i, peopleSkillsMask);
        }
        dp = new Long[(1 << n)];
        long answerMask = dfs(skillsMask);
        int ans[] = new int [Long.bitCount(answerMask)];
        int ptr = 0;
        for (int i = 0; i < m; i++) {
            if (((answerMask >> i) & 1) == 1) {
                ans[ptr++] = i;
            }
        }
        return ans;
    }
    public Long dfs(int skillsMask) {
        if (skillsMask == 0) {
            return 0L;
        }
        if (dp[skillsMask] != null) {
            return dp[skillsMask];
        }
        for (int i = 0; i < peopleSkillMap.size(); i++) {
            int smallerSkillsMask = skillsMask & ~peopleSkillMap.get(i);
            if (smallerSkillsMask != skillsMask) {
                //taking ith person, set the ith bit
                long peopleMask = dfs(smallerSkillsMask) | (1L << i);
                if (dp[skillsMask] == null || Long.bitCount(peopleMask) <
                                                Long.bitCount(dp[skillsMask])) {
                    dp[skillsMask] = peopleMask;
                }
            }
        }
        return dp[skillsMask];
    }
}