function isObject(object) {
  return object != null && typeof object === 'object';
}

function objDiff(o1, o2) {
    let isO1 = isObject(o1)
    let isO2 = isObject(o2)
    let isA1 = Array.isArray(o1)
    let isA2 = Array.isArray(o2)
    if(!isO1 && !isO2 && o1 === o2) {
        return {}
    } else if((isO1 && !isO2) || (!isO1 && isO2) || (!isO1 && !isO2 && o1 !== o2)) {
        return [o1, o2]
    } else if((isA1 && !isA2) || (!isA1 && isA2)) {
        return [o1, o2]
    }
    
    let kys1 = Object.keys(o1)
    let kys2 = Object.keys(o2)
    let ans = {}
    for(let k of kys1) {
        if(kys2.includes(k)) {
            let subDiff = objDiff(o1[k], o2[k])
            if (Object.keys(subDiff).length > 0) {
                ans[k] = subDiff;
            }
        }
    }
    
    return ans
};






