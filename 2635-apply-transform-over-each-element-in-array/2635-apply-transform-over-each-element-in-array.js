/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let ar = []
    for(let x in arr) {
        ar.push(fn(arr[x], Number(x)))
    }
    return ar
};