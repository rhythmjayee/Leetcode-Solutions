function missingNumber(nums: number[]): number {
    const n : number = nums.length;
    let xor = nums.reduce((acc : number, num : number) => acc ^ num, 0);
    for(let i = 1; i <= n; i++) {
        xor = xor ^ i;
    }
    return xor;
};