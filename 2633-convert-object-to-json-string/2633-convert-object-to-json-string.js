/**
 * @param {any} object
 * @return {string}
 */
var jsonStringify = function(obj) {
    if(obj === null) return null
    else if(obj === true || obj === false) return obj === true
    else if(typeof obj === 'string') return "\"" + obj + "\"" //string -> "string"
    else if(Number.isInteger(obj)) return Number(obj)
    
    let keys = Object.keys(obj)
    let isArray = Array.isArray(obj)
    let ans = isArray ? "[" : "{"
    for(let key of keys) {
        let res = jsonStringify(obj[key])//convert the val
        if(isArray) {
            if(ans[ans.length - 1] !== "[") ans += ","
            ans += res
        }else {
            if(ans[ans.length - 1] !== "{") ans += ","
            // "key":stringify_value
            ans += "\"" + key + "\"" + ":" + res
        }
    }
    ans += isArray ? "]" : "}"
    return ans
};