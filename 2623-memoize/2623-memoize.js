/**
 * @param {Function} fn
 */
function memoize(fn) {
    let map = new Map()
    return function(...args) {
        let st = String(fn)+[...args]
        if(map.has(st)) return map.get(st) 
        let v = fn(...args)
        map.set(st, v)
        return v;
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */