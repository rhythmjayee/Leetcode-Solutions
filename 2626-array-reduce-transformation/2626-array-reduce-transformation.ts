type Fn = (accum: number, curr: number) => number

function reduce(nums: number[], fn: Fn, init: number): number {
    const ans: number = nums.reduce((acc, num) => fn(acc, num), init);
    return ans;
};