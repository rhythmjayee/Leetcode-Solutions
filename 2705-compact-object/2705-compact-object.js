/**
 * @param {Object} obj
 * @return {Object}
 */
var compactObject = function(obj) {
    let arr = []
    let newObj = {}
    let isArry = false
    if(!(obj instanceof Object) && !(obj)) return null
    else if(!(obj instanceof Object) && (obj)) return obj
    if(Array.isArray(obj)) isArry = true
    
    let keys = Object.keys(obj);
    for(let k of keys) {
        let res = compactObject(obj[k])
        if(res !== null) {
            if(isArry) arr.push(res)
            else newObj[k] = res
        }
    }
    return isArry ? arr : newObj
};