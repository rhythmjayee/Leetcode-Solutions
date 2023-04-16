
var TimeLimitedCache = function() {
    this.cache = new Map()
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    let hasKey = this.get(key)
    this.cache.set(key, [value, (Date.now() + Number(duration))])
    return hasKey === -1 ? false : true
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    let hasKey = this.cache.has(key)
    if(!hasKey) return -1;
    let v = this.cache.get(key)
    let isExpired = (Date.now() >= v[1] ? true : false)
    if(isExpired) this.cache.delete(key)
    return isExpired ? -1 : v[0]
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    let c = 0;
    for(let [k,v] of this.cache) {
        this.get(k)
    }
    return this.cache.size
};

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * var obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // false
 * obj.get(1) // 42
 * obj.count() // 1
 */