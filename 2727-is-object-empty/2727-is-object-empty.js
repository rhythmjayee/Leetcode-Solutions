/**
 * @param {Object | Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    let keys = Object.keys(obj)
    return keys.length === 0
};