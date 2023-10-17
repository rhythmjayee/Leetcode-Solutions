class Solution {
public:
    bool splitArray(vector<int>& nums, int i, int sum, int count, map<string, bool> &dp){
        int n = nums.size();

        string key = to_string(i) + ' ' + to_string(sum) + ' ' + to_string(count);
        
        if(sum == 0 && count == 0){
            return true;
        }

        if(i >= n || count < 0 || sum < 0)
            return false;

        if(dp.find(key) != dp.end()){
            return dp[key];
        }

        return dp[key] = 
            splitArray(nums, i + 1, sum - nums[i], count - 1, dp) || 
            splitArray(nums, i + 1, sum , count, dp);
    }

    bool splitArraySameAverage(vector<int>& nums) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
    
        map<string, bool> dp;

        bool ans = false;
        
        for(int c = 1; c <= n / 2 && !ans; c++){
            if((sum * c) % n)
                continue;
                
            int s = sum * c / n;

            ans = splitArray(nums, 0, s, c, dp);

        }

        return ans;
    }
};