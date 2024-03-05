type Fn = (n: number, i: number) => any

function filter(arr: number[], fn: Fn): number[] {
    const ans: number[] = arr.filter((num, i) => fn(num, i));
    return ans;
};