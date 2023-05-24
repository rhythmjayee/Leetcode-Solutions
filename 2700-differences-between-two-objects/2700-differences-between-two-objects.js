function isObject(object) {
  return object != null && typeof object === 'object';
}

function objDiff(obj1, obj2) {
    let kys1 = Object.keys(obj1)
    let kys2 = Object.keys(obj2)
    let ans = {}
    for(let k of kys1) {
        if(kys2.includes(k)) {
            getDiff(k, obj1[k], obj2[k], ans)
        }
    }
    return ans
};

const getDiff = (k, o1, o2, ans) => {
    let isO1 = isObject(o1)
    let isO2 = isObject(o2)
    let isA1 = Array.isArray(o1)
    let isA2 = Array.isArray(o2)
    if(!isO1 && !isO2 && o1 === o2) {
        return 
    } else if((isO1 && !isO2) || (!isO1 && isO2) || (!isO1 && !isO2 && o1 !== o2)) {
        ans[k] = [o1, o2]
        return
    } else if((isA1 && !isA2) || (!isA1 && isA2)) {
        ans[k] = [o1, o2]
        return
    }
    
    let kys1 = Object.keys(o1)
    let kys2 = Object.keys(o2)
    let next = {}
    for(let kk of kys1) {
        if(kys2.includes(kk)) {
            getDiff(kk, o1[kk], o2[kk], next)
        }
    }
    
    let hasDiff = Object.keys(next).length > 0
    if(hasDiff) ans[k] = next
}






