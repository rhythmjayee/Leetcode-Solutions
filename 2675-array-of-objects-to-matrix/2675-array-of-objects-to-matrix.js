/**
 * @param {Array} arr
 * @return {Matrix}
 */
var pushInMap = (map1, obj, index, prevKeyFormed) => {
    let insideMap;
    let arr;
    if(!map1.has(prevKeyFormed)) {
        map1.set(prevKeyFormed, new Map())
    }
    insideMap = map1.get(prevKeyFormed)
    if(!insideMap.has(index)) {
        insideMap.set(index, obj)
    }
}
var pushKeyValue = (map1, obj, index, prevKeyFormed) => {
    if(!(obj instanceof Object)) {
        pushInMap(map1, obj, index, prevKeyFormed)
        return
    }
    let keys = Object.keys(obj)
    for(let key of keys) {
        if(prevKeyFormed !== "") {
            pushKeyValue(map1, obj[key], index, prevKeyFormed+"."+key)
        }else {
            pushKeyValue(map1, obj[key], index, key)
        }
    }
}
var buildArr = (arr, map1, keys, index, len) => {
    if(len == index) return
    let newArr = []
    for(let k of keys) {
        let inMap = map1.get(k)
        if(inMap.has(index)) {
            newArr.push(inMap.get(index))
        }else {
            newArr.push("")
        }
    }
    arr.push(newArr)
    buildArr(arr, map1, keys, index + 1, len)
}
var jsonToMatrix = function(arr) {
    const map1 = new Map()
    for(let i = 0; i < arr.length; i++) {
        pushKeyValue(map1, arr[i], i, "")
    }
    let it = map1.keys()
    let keys = []
    for(let k of it) keys.push(k)
    keys.sort((a, b) => {
        return a.localeCompare(b)
    })
    let ans = []
    ans.push(keys)
    buildArr(ans, map1, keys, 0, arr.length)
    return ans
};