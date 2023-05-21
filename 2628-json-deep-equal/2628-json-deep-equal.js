/**
 * @param {any} o1
 * @param {any} o2
 * @return {boolean}
 */
var areDeeplyEqual = function(o1, o2) {
    if (o1 === o2) {//check if same non object values
        return true;
    }
    //check if object, both should be object
    if (typeof o1 !== 'object' || o1 === null || typeof o2 !== 'object' || o2 === null) {
        return false;
    }
    //check if array, both should be array
    if (Array.isArray(o1) !== Array.isArray(o2)) {
        return false;
    }
    //rest everthing is object
    const keys1 = Object.keys(o1);
    const keys2 = Object.keys(o2);
    if (keys1.length !== keys2.length) {
        return false;
    }
    for(let key of keys1){
        //check if both has the key
        if(keys2.includes(key) === false) return false
        //check the both values are equals for same key
        let checkNextLvl = areDeeplyEqual(o1[key], o2[key])
        if(checkNextLvl === false) return false
    }
    return true
};