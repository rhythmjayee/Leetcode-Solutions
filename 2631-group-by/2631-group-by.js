/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function(fn) {
    let obj = {}
    for(let key of this) {
        let ans = fn(key)
        if(obj[ans] === undefined) {
            obj[ans] = []
        }
        obj[ans].push(key)
    }
    return obj
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */