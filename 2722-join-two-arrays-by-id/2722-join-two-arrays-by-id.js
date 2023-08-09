/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var formObj = (resObj, arr) => {
    for (let obj of arr) {
        // console.log(obj)
        let id = obj["id"]
        if( resObj[id] === undefined) {
             resObj[id] = {}
        }
        let keys = Object.keys(obj)
        for(let k of keys) {
            // console.log(k)
            resObj[id][k] = obj[k]
        }
    }
}
var join = function(arr1, arr2) {
    let resObj = {}
    let ans = []
    formObj(resObj, arr1)
    formObj(resObj, arr2)
    // console.log(resObj)
    for(let k of Object.keys(resObj)) {
        ans.push(resObj[k])
    }
    ans.sort((a, b) => a.id - b.id)
    return ans
};