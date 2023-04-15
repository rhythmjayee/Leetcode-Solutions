/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
var flat = flattenArray

function flattenArray (arr, n) {
    if(n === 0) return arr

    let ans = []
    for(let ele of arr) {
        if(Array.isArray(ele)) {
            let res = flattenArray(ele, n - 1)
            ans.push(...res)
        }else {
            ans.push(ele)
        }
    }
    return ans
}