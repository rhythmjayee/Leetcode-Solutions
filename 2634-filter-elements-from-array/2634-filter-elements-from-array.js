/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let narr = []
    for (let x in arr) {
        let ans = fn(arr[x], Number(x))
        if(ans) narr.push(arr[x])
    }
    return narr
};