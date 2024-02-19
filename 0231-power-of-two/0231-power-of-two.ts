function isPowerOfTwo(n: number): boolean {
    if(n === 0) return false;
    let count : number = 0;
    while(n > 0){
        let rmsb = (n & (-n));
        n -= rmsb;
        count += 1;
        if(count > 1) return false;
    }
    return count === 1;
};