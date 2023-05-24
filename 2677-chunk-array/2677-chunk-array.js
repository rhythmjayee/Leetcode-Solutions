/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    if(arr.length == 0) return []
    else if(arr.length < size) return [arr]
    let ans = []
    let i = 0;
    while(i < arr.length) {
        let sub = []
        let k = size
        while(i < arr.length && k-- > 0) {
            sub.push(arr[i]);
            i += 1
        }
        ans.push(sub)
    }
    return ans
};
