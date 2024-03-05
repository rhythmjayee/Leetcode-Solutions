function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    const ans: number[] = arr.map((num, i) => fn(num, i));
    return ans;
};