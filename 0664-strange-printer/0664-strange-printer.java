public class Solution {
    public int strangePrinter(String s) {
        return strangePrinter(0, s.length() - 1, s, new Integer[s.length()][s.length()]);
    }

    private int strangePrinter(int i, int j, String s, Integer[][] memo) {
        if (i == j) return 1;
        if (memo[i][j] != null) return memo[i][j];

        int minTurns = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            minTurns = Math.min(
                minTurns,
                strangePrinter(i, k, s, memo) + strangePrinter(k + 1, j, s, memo)
            );
        }

        return memo[i][j] = (s.charAt(i) == s.charAt(j)) ? minTurns - 1 : minTurns;
    }
}