function createCounter(n: number): () => number {
    let num : number = n - 1;
    return () : number => {
        num = num + 1;//clouser on num
        return num;
    }
}


/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */