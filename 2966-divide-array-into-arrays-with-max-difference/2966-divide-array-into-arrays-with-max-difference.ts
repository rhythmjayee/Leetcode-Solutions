function divideArray(nums: number[], k: number): number[][] {
    var sortedArray: number[] = nums.sort((n1,n2) => n1 - n2);
    if(nums.length % 3 != 0) return [];
    var ans: number[][] = [];
    for(let i: number = 0; i < nums.length - 2; i += 3) {
        if(nums[i + 2] - nums[i] <= k) {
            ans.push([nums[i], nums[i + 1], nums[i + 2]]);
        } else return [];
    }
    return ans;
};