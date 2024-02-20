function missingNumber(nums: number[]): number {
    const n : number = nums.length;
    let xor = 0;
    for(let i = 0; i < n; i++) {
        xor = xor ^ i;
        xor = xor ^ nums[i];
    }
    return xor ^ n;
};