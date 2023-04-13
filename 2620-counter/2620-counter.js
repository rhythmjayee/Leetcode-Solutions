/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let nn = n - 1
    return function() {
        nn = Number(nn + 1)
        return nn;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */