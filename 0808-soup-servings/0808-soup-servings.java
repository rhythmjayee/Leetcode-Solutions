class Solution {
    public double soupServings(int N) {
        if (N >= 5000) {  // trick
            return 1.0;
        }
        return helper(N, N, new Double[N + 1][N + 1]);
    }
    
    public double helper(int A, int B, Double[][] memo) {
        if (A <= 0 && B <= 0) return 0.5;     // base case 1
        if (A <= 0) return 1.0;               // base case 2
        if (B <= 0) return 0.0;               // base case 3
        if (memo[A][B] != null) {
            return memo[A][B];
        }
        int[] serveA = {100, 75, 50, 25};
        int[] serveB = {0, 25, 50, 75};
        memo[A][B] = 0.0;
        for (int i = 0; i < 4; i++) {
            memo[A][B] += helper(A - serveA[i], B - serveB[i], memo);
        }
        return memo[A][B] *= 0.25;
    }
    /**
    Return 0.5 is because the question said: Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time.
When N > 5000, the probability is already very close to 1.0. The question said: Note that we do not have the operation where all 100 ml's of soup B are used first., so A is more likely to be empty earlier than B. When the N is larger, the probability is higher, so we just return 1.0.
    **/
}