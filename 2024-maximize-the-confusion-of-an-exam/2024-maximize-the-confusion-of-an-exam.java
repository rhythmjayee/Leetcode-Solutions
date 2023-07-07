class Solution {
    public int maxTOrFWeCanGet(String str, int k, char chr) {
        int start = 0;
        int n = str.length();
        int max = 0;
        char otherChar = chr == 'T' ? 'F' : 'T';
        int c1 = 0;
        int c2 = 0;
        for(int end = 0; end < n; end++) {
            char cur = str.charAt(end);
            if(cur == chr) {
                c1++;
            } else {
                c2++;
            }
            if(c2 - k <= 0) {
                max = Math.max(max, c1 + c2);
            }
            while(start <= end && c2 - k > 0) {
                if(str.charAt(start) == otherChar) {
                    c2--;
                }else {
                    c1--;
                }
                start++;
            }
        }
        return max;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxT = maxTOrFWeCanGet(answerKey, k, 'T');
        int maxF = maxTOrFWeCanGet(answerKey, k, 'F');
        return Math.max(maxT, maxF);
    }
}