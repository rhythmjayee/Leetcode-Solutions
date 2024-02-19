function isPowerOfTwo(n: number): boolean {
    if(n === 0) return false;
    const log2: number = Math.log2(n);
    const flr: number = Math.floor(log2);
    const ceil: number = Math.ceil(log2);
    return flr === ceil;
};