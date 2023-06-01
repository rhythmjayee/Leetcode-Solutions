/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {
    let ans = depp(arr)
    for(let a of ans) yield a
};
function depp(arr) {
    let ans = []
    for(let a of arr) {
        if(Array.isArray(a)) {
            let rs = depp(a)
            ans = ans.concat(rs)
        } else {
           ans.push(a)
        }
        
    }
    return ans
}

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */